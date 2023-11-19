package br.com.fiap.healthtie.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import br.com.fiap.healthtie.R
import br.com.fiap.healthtie.databinding.FragmentReminderListBinding
import br.com.fiap.healthtie.domain.ReminderModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.coroutines.launch

class ReminderListFragment : Fragment() {

    lateinit var binding: FragmentReminderListBinding
    private val viewModel: ReminderViewModel by viewModels()

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
        binding = FragmentReminderListBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        getDataFromDataBase()
        setObservers()
    }

    private fun setObservers() {
        viewModel.reminders.observe(
            viewLifecycleOwner,
            Observer {
                reminderAdapter.setData(it)
            }
        )
    }

    private fun updateReminder(reminderModel: ReminderModel) {
        goToRegisterReminder(reminderModel)
    }

    private fun goToRegisterReminder(reminderModel: ReminderModel? = null) {
        findNavController().navigate(
            R.id.action_to_reminder_form,
            ReminderFormFragment.buildBundle(reminderModel)
        )
    }

    private fun deleteReminder(reminderModel: ReminderModel) {
        lifecycleScope.launch {
            viewModel.deleteReminder(reminderModel)

            SnackBarUtil.showSnackBar(
                binding.reminderListRecycler,
                getString(
                    R.string.register_reminder_sucess_deleted_message,
                    reminderModel.title
                )
            )

            getDataFromDataBase()
        }
    }

    private fun getDataFromDataBase() {
        lifecycleScope.launch {
            viewModel.selectReminders()
        }
    }

    private fun setupViews() {
        binding.reminderListRecycler.setHasFixedSize(true)
        binding.reminderListRecycler.adapter = reminderAdapter

        binding.reminderListAddButton.setOnClickListener {
            findNavController().navigate(
                R.id.action_to_reminder_form
            )
        }
    }

    private fun openConfirmationDeleteDialog(reminderModel: ReminderModel) {
        context?.let {
            MaterialAlertDialogBuilder(it)
                .setTitle(resources.getString(R.string.delete_dialog_title))
                .setMessage(
                    resources.getString(
                        R.string.delete_dialog_message,
                        reminderModel.title
                    )
                )
                .setNeutralButton(resources.getString(R.string.delete_cancel_label)) { dialog, _ ->
                    dialog.cancel()
                }
                .setPositiveButton(resources.getString(R.string.delete_continue_label)) { dialog, _ ->
                    deleteReminder(reminderModel)
                    dialog.dismiss()
                }
                .show()
        }
    }
}