package br.com.fiap.healthtie.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import br.com.fiap.healthtie.data.AppDatabase
import br.com.fiap.healthtie.domain.ReminderModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ReminderListViewModel(private val application: Application) : AndroidViewModel(application) {

    val reminders = MutableLiveData<List<ReminderModel>>()
    val remindersInserted = MutableLiveData<String>()
    val remindersDeleted = MutableLiveData<String>()
    val remindersUpdated = MutableLiveData<String>()
    suspend fun selectReminders() {
        withContext(Dispatchers.IO) {
            launch {
                val result =
                    AppDatabase.getDataBase(application.applicationContext).reminderDAO().select()
                withContext(Dispatchers.Main) {
                    reminders.value = result
                }

            }
        }
    }

    suspend fun insertReminder(reminderModel: ReminderModel) {
        withContext(Dispatchers.IO) {
            launch {
                AppDatabase.getDataBase(application.applicationContext).reminderDAO()
                    .insert(reminderModel)
                withContext(Dispatchers.Main) {
                    remindersInserted.value = "Você inseriu um lembrete com sucesso"
                }
            }
        }
    }

    suspend fun updateReminder(reminderModel: ReminderModel) {
        withContext(Dispatchers.IO) {
            launch {
                AppDatabase.getDataBase(application.applicationContext).reminderDAO()
                    .update(reminderModel)
                withContext(Dispatchers.Main) {
                    remindersUpdated.value = "Você alterou um lembrete com sucesso"
                }
            }
        }
    }

    suspend fun deleteReminder(reminderModel: ReminderModel) {
        withContext(Dispatchers.IO) {
            launch {
                AppDatabase.getDataBase(application.applicationContext).reminderDAO()
                    .delete(reminderModel)
                withContext(Dispatchers.Main) {
                    remindersDeleted.value = "Você deletou um lembrete com sucesso"
                }
            }
        }
    }

}