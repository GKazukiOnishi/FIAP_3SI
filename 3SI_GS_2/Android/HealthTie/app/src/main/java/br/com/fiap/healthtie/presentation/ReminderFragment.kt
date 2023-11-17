package br.com.fiap.healthtie.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.fiap.healthtie.R
import br.com.fiap.healthtie.data.AppDatabase
import br.com.fiap.healthtie.databinding.FragmentReminderBinding
import br.com.fiap.healthtie.domain.ReminderModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class ReminderFragment: Fragment() {

    lateinit var binding: FragmentReminderBinding

    private val appDb : AppDatabase? by lazy {
        view?.context?.let {
            AppDatabase.getDataBase(it)
        }
    }

    private val reminderAdapter by lazy {
        ReminderAdapter(
            onDeleteListener = ::openConfirmationDeleteDialog,
            onUpdateListener = ::updateReminder
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentReminderBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun updateReminder(reminderModel: ReminderModel){
        goToRegisterReminder(reminderModel)
    }

    private fun goToRegisterReminder(reminderModel: ReminderModel? = null){
        findNavController().navigate(R.id.action_toRegisterReminderFragment, RegisterReminderFragment.buildBundle(reminderModel))
    }

    private fun deleteReminder(reminderModel: ReminderModel){
        appDb?.reminderDAO()?.delete(reminderModel)
        SnackBarUtil.showSnackBar(
            binding.recyclerViewReminder, //passar o id da minha recycler view de lembretes
            getString(
                R.string.register_reminder_sucess_deleted_message,
                reminderModel.title
            )
        )

        getDataFromDataBase()
    }

    private fun getDataFromDataBase(){
        appDb?.reminderDAO()?.select()?.let {
            reminderAdapter.setData(it)
        }
    }

    private fun setupViews(){
        //colocar o id do floatingActionButton que vai inserir novos lembretes
        binding.buttonAddReminder.setOnClickListener{
            findNavController().navigate(
                R.id.action_toRegisterReminderFragment
            )
        }

        //id da RecyclerView que vai estar reproduzindo a view reminder item
        binding.recyclerViewReminder.setHasFizedSize(true)
        binding.recyclerViewReminder.adapter = reminderAdapter

        getDataFromDataBase()
    }

    private fun openConfirmationDeleteDialog(reminderModel: ReminderModel){
        context?.let{
            MaterialAlertDialogBuilder(it)
                .setTitle(resources.getString(R.string.delete_dialog_title))
                .setMessage(resources.getString(R.string.delete_dialog_message, reminderModel.title))
                .setNeutralButton(resources.getString(R.string.delete_cancel_label)){dialog, _ ->
                    dialog.cancel()
                }
                .setPositiveButton(resources.getString(R.string.delete_continue_label)){dialog, _ ->
                    deleteReminder(reminderModel)
                    dialog.dismiss()
                }
                .show()
        }
    }
}