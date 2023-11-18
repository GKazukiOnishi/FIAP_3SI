package br.com.fiap.healthtie.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import br.com.fiap.healthtie.R
import br.com.fiap.healthtie.data.AppDatabase
import br.com.fiap.healthtie.databinding.FragmentReminderFormBinding
import br.com.fiap.healthtie.domain.ReminderModel
import br.com.fiap.healthtie.presentation.SnackBarUtil.showSnackBar
import java.time.LocalDateTime

class ReminderFormFragment : Fragment() {

    private lateinit var binding: FragmentReminderFormBinding

    private val reminderInfoArgument by lazy {
        arguments?.getParcelable(REMINDER_MODEL_BUNDLE_KEY) as? ReminderModel
    }

    private val appDb: AppDatabase? by lazy {
        view?.context?.let {
            AppDatabase.getDataBase(it)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentReminderFormBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews(){

        binding.reminderFormCadButton.run{
            text = if(reminderInfoArgument == null){
               getString(R.string.register_reminder_button_label)
            }else {
                getString(R.string.update_reminder_button_label)
            }

            setOnClickListener{
                insertUpdateData()
            }
        }

        reminderInfoArgument?.let { reminderInfoArgument ->
            binding.run {
                textInputEditTextReminderTitle.setText(reminderInfoArgument.title)
                textInputEditTextReminderDescription.setText(reminderInfoArgument.description)
                //textInputEditTextReminderReminderDate.setText(reminderInfoArgument.reminderDateTime)
                textInputEditTextReminderLocation.setText(reminderInfoArgument.location)
            }
        }
    }

    private fun insertUpdateData(){
        binding.run {
            val reminderModel = ReminderModel(
                title = textInputEditTextReminderTitle.text.toString(),
                description = textInputEditTextReminderDescription.text.toString(),
                location = textInputEditTextReminderLocation.text.toString(),
                reminderDateTime = LocalDateTime.now(),
                inserted = true
            )

            reminderInfoArgument?.let {
                reminderModel.id = it.id
            }

            if(reminderInfoArgument != null){
                appDb?.reminderDAO()?.update(reminderModel)
                showSnackBar(
                    binding.reminderFormCadButton,
                    getString(R.string.register_reminder_sucess_updated_message, reminderModel.title)
                )
            }else{
                appDb?.reminderDAO()?.insert(reminderModel)
                showSnackBar(
                    binding.reminderFormCadButton,
                    getString(R.string.register_reminder_sucess_registered_message, reminderModel.title)
                )
            }
        }

    }

    private fun cleanForm(){
        binding.run {
            textInputEditTextReminderTitle.text?.clear()
            textInputEditTextReminderDescription.text?.clear()
            //textInputEditTextReminderReminderDate.text?.clear()
            textInputEditTextReminderLocation.text?.clear()
        }
    }

    companion object{
        private const val REMINDER_MODEL_BUNDLE_KEY = "REMINDER_MODEL_BUNDLE_KEY"

        fun buildBundle(reminderModel: ReminderModel?): Bundle?{
            return reminderModel?.let{
                bundleOf(REMINDER_MODEL_BUNDLE_KEY to it)
            }
        }
    }
}