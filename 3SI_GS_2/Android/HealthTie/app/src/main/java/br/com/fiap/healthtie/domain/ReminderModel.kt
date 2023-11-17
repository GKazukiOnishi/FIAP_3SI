package br.com.fiap.healthtie.domain

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

const val REMINDER_MODEL_TABLE_NOME = "reminderTable"

@Entity(tableName = REMINDER_MODEL_TABLE_NOME)
@Parcelize
data class ReminderModel(

    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    @NonNull @ColumnInfo val title: String,
    @NonNull @ColumnInfo val reminderDateTime: LocalDateTime,
    @NonNull @ColumnInfo val description: String,
    @NonNull @ColumnInfo val location: String,
    @NonNull @ColumnInfo val inserted: Boolean,

): Parcelable {
     fun formatReminderDateTime(): String {
        val formatter = DateTimeFormatter.ofPattern("dd/MM 'às' HH'h'mm", Locale.getDefault())
        return reminderDateTime.format(formatter);
    }
}
