package br.com.fiap.healthtie.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.com.fiap.healthtie.domain.REMINDER_MODEL_TABLE_NOME
import br.com.fiap.healthtie.domain.ReminderModel


@Dao
interface ReminderDAO {
    @Query("SELECT * FROM $REMINDER_MODEL_TABLE_NOME ORDER BY id")
    suspend fun select(): List<ReminderModel>

    @Insert
    suspend fun insert(reminderModel: ReminderModel)

    @Update
    suspend fun update(reminderModel: ReminderModel)

    @Delete
    suspend fun delete(reminderModel: ReminderModel)
}