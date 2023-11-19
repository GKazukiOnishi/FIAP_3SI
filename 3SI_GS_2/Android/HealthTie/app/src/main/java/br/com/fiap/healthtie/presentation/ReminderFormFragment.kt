package br.com.fiap.healthtie.presentation

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import br.com.fiap.healthtie.R

import br.com.fiap.healthtie.databinding.FragmentReminderFormBinding
import br.com.fiap.healthtie.domain.ReminderModel
import br.com.fiap.healthtie.presentation.SnackBarUtil.showSnackBar

import kotlinx.coroutines.launch
import java.text.SimpleDateFormat

import java.time.LocalDateTime

import java.time.format.DateTimeFormatter
import java.util.Calendar

import java.util.Locale

class ReminderFormFragment : Fragment() {

    private lateinit var binding: FragmentReminderFormBinding
    private val viewModel: ReminderListViewModel by viewModels()
    private val calendar = Calendar.getInstance()

    private val reminderInfoArgument by lazy {
        arguments?.getParcelable(REMINDER_MODEL_BUNDLE_KEY) as? ReminderModel
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
        setupObservers()
    }

    private fun setupViews() {

        binding.textInputEditTextReminderDate.setOnClickListener {
            showDatePicker()
        }

        binding.textInputEditTextReminderHour.setOnClickListener {
            showHourPicker()
        }


        binding.reminderFormCadButton.run {
            text = if (reminderInfoArgument == null) {
                getString(R.string.register_reminder_button_label)
            } else {
                getString(R.string.update_reminder_button_label)
            }

            setOnClickListener {
                insertUpdateData()
            }
        }

        reminderInfoArgument?.let { reminderInfoArgument ->
            binding.run {
                textInputEditTextReminderTitle.setText(reminderInfoArgument.title)
                textInputEditTextReminderDescription.setText(reminderInfoArgument.description)
                textInputEditTextReminderDate.setText(convertLocalDateTimeToDateString(reminderInfoArgument.reminderDateTime))
                textInputEditTextReminderHour.setText(convertLocalDateTimeToTime(reminderInfoArgument.reminderDateTime))
                textInputEditTextReminderLocation.setText(reminderInfoArgument.location)
            }
        }
    }

    private fun convertLocalDateTimeToDateString(localDataDatabase: LocalDateTime): String{
        val patternDate = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        return localDataDatabase.format(patternDate)
    }

    private fun convertLocalDateTimeToTime(localDateTime: LocalDateTime): String {
        val patternHour = DateTimeFormatter.ofPattern("HH:mm")
        return localDateTime.format(patternHour)
    }


    private fun showHourPicker() {
        val cal = Calendar.getInstance()
        val timeSetListerner = TimePickerDialog.OnTimeSetListener{
            _, hour, minute ->
            cal.set(Calendar.HOUR_OF_DAY, hour)
            cal.set(Calendar.MINUTE, minute)
            cal.set(Calendar.HOUR_OF_DAY, hour)

            binding.textInputEditTextReminderHour.setText(SimpleDateFormat("HH:mm", Locale.getDefault()).format(cal.time))
        }

        TimePickerDialog(context, timeSetListerner, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()
    }

    private fun showDatePicker() {
        val datePickerDialog = view?.let {
            DatePickerDialog(
                requireContext(),
                { _, year: Int, monthOfYear: Int, dayOfMonth: Int ->
                    val selectedDate = Calendar.getInstance()
                    selectedDate.set(year, monthOfYear, dayOfMonth)
                    val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                    var formattedDate: String = dateFormat.format(selectedDate.time)
                    binding.textInputEditTextReminderDate.setText(formattedDate)

//                    val date = LocalDate.of(year, monthOfYear+1, dayOfMonth)
//                    val dateAux = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant())
//                    val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
//                    val formattedDate = dateFormat.format(dateAux)
//                    binding.textInputEditTextReminderDate.setText(formattedDate)
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH),
            )
        }

        datePickerDialog?.show()

    }


    private fun setupObservers() {
        viewModel.remindersInserted.observe(
            viewLifecycleOwner,
            Observer {
                showSnackBar(
                    binding.reminderFormCadButton,
                    it
                )
            }
        )

        viewModel.remindersUpdated.observe(
            viewLifecycleOwner,
            Observer {
                showSnackBar(
                    binding.reminderFormCadButton,
                    it
                )
            }
        )
    }


    private fun convertStringToLocalDateTime(): LocalDateTime{

        val dateString = binding.textInputEditTextReminderDate.text.toString()
        val hourString = binding.textInputEditTextReminderHour.text.toString()

        val dateTimeString = "$dateString $hourString:00"
        val customFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")

        return LocalDateTime.parse(dateTimeString,customFormatter)
    }
    private fun insertUpdateData() {

        binding.run {


            val reminderModel = ReminderModel(
                title = textInputEditTextReminderTitle.text.toString(),
                description = textInputEditTextReminderDescription.text.toString(),
                location = textInputEditTextReminderLocation.text.toString(),
                reminderDateTime = convertStringToLocalDateTime(),
                inserted = true
            )

            reminderInfoArgument?.let {
                reminderModel.id = it.id
            }

            lifecycleScope.launch {
                if (reminderInfoArgument != null) {
                    viewModel.updateReminder(reminderModel)
                } else {
                    viewModel.insertReminder(reminderModel)
                }
            }
        }
        clearForm()

    }

    private fun clearForm() {
        binding.run {
            textInputEditTextReminderTitle.text?.clear()
            textInputEditTextReminderDescription.text?.clear()
            textInputEditTextReminderDate.text?.clear()
            textInputEditTextReminderHour.text?.clear()
            textInputEditTextReminderLocation.text?.clear()
        }
    }

    companion object {
        private const val REMINDER_MODEL_BUNDLE_KEY = "REMINDER_MODEL_BUNDLE_KEY"

        fun buildBundle(reminderModel: ReminderModel?): Bundle? {
            return reminderModel?.let {
                bundleOf(REMINDER_MODEL_BUNDLE_KEY to it)
            }
        }
    }
}