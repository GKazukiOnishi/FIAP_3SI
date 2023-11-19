package br.com.fiap.healthtie.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import br.com.fiap.healthtie.data.AppDatabase
import br.com.fiap.healthtie.domain.FamilyGroupModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FamilyGroupListViewModel(private val application: Application) : AndroidViewModel(application) {
    val groupFamily = MutableLiveData<List<FamilyGroupModel>>()

    suspend fun selectGroupFamily(){
        withContext(Dispatchers.IO){
            launch {
                val result = AppDatabase.getDataBase(application.applicationContext).familyGroupDAO().select()
                withContext(Dispatchers.Main) {
                    groupFamily.value = result
                }
            }
        }
    }
}