package br.com.fiap.healthtie.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import br.com.fiap.healthtie.domain.FamilyGroupKindship
import br.com.fiap.healthtie.domain.FamilyGroupModel
import br.com.fiap.healthtie.domain.ReminderModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

const val HEALTH_TIE_DATABASE_NAME = "HEALTHTIE_DATABASE"

@Database(entities = [ReminderModel::class, FamilyGroupModel::class], version = 1)
@TypeConverters(LocalDateTimeConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun reminderDAO(): ReminderDAO
    abstract fun familyGroupDAO(): FamilyGroupDAO

    companion object {
        private var INSTANCE: AppDatabase? = null

        suspend fun getDataBase(context: Context): AppDatabase {
            if (INSTANCE != null) {
                return INSTANCE!!
            } else {
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    HEALTH_TIE_DATABASE_NAME,

                    ).build()
                INSTANCE = instance


                val familyGroupList = listOf(
                    FamilyGroupModel(
                        namePerson = "Breno Silva",
                        note = "Eletrocardiograma (ECG)",
                        kinship = FamilyGroupKindship.BROTHER
                    ),
                    FamilyGroupModel(
                        namePerson = "Gabriel Onishi Kazuki",
                        note = "Oftalmologista",
                        kinship = FamilyGroupKindship.BROTHER
                    ),
                    FamilyGroupModel(
                        namePerson = "Maria da Silva",
                        note = "Retirada de medicamento",
                        kinship = FamilyGroupKindship.GRANDMOTHER
                    ),
                    FamilyGroupModel(
                        namePerson = "João da Silva",
                        note = "Ressonância Magnética (RM)",
                        kinship = FamilyGroupKindship.FATHER
                    ),
                    FamilyGroupModel(
                        namePerson = "Ana da Silva",
                        note = "Vacina COVID-19",
                        kinship = FamilyGroupKindship.MOTHER
                    ),
                )

                val dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")
                val reminderGroupList = listOf(
                    ReminderModel(
                        title = "Exame de Endoscopia",
                        reminderDateTime = LocalDateTime.parse("25/11/2023 08:30:00",dateTimeFormatter),
                        description = "Jejum de 8h",
                        location = "Hospital da Luz, São Paulo",
                        inserted = true
                    ),
                    ReminderModel(
                        title = "Retirar Medicamentos",
                        reminderDateTime = LocalDateTime.parse("02/12/2023 12:45:00", dateTimeFormatter),
                        description = "Levar Carteirinha do SUS",
                        location = "UBS Vila Penteado, São Paulo",
                        inserted = true
                    ),
                    ReminderModel(
                        title = "Vacina contra Febre Amarela",
                        reminderDateTime = LocalDateTime.parse("15/12/2023 16:00:00", dateTimeFormatter),
                        description = "Levar RG ou CNH",
                        location = "UBS Santana, São Paulo",
                        inserted = true
                    ),
                    ReminderModel(
                        title = "Consulta Dr. José Viana",
                        reminderDateTime = LocalDateTime.parse("28/11/2023 06:00:00", dateTimeFormatter),
                        description = "Chegar cedo ao consultório",
                        location = "Perdizes, São Paulo",
                        inserted = true
                    ),
                    ReminderModel(
                        title = "Aula de Yoga",
                        reminderDateTime = LocalDateTime.parse("10/12/2023 18:00:00", dateTimeFormatter),
                        description = "Relaxamento e meditação",
                        location = "Vila Mariana, São Paulo",
                        inserted = true
                    ),
                    ReminderModel(
                        title = "Corrida no Parque",
                        reminderDateTime = LocalDateTime.parse("12/12/2023 07:30:00", dateTimeFormatter),
                        description = "Manhã energizante",
                        location = "Parque Ibirapuera, São Paulo",
                        inserted = true
                    )
                )


                if (INSTANCE?.familyGroupDAO()?.select()?.isEmpty() == true) {
                    familyGroupList.forEach {
                        INSTANCE?.familyGroupDAO()?.insert(it)
                    }
                }

                if (INSTANCE?.reminderDAO()?.select()?.isEmpty() == true) {
                    reminderGroupList.forEach {
                        INSTANCE?.reminderDAO()?.insert(it)
                    }
                }



                return instance
            }
        }
    }
}