package br.com.fiap.healthtie.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.fiap.healthtie.domain.ReminderModel

const val REMINDER_DATABASE_NAME = "REMINDER_DATABASE_NAME"
@Database(entities = [ReminderModel::class], version = 1)
abstract class AppDatabase : RoomDatabase(){

    abstract fun reminderDAO(): ReminderDAO

    companion object{
        private var INSTANCE: AppDatabase? = null

        fun getDataBase(context: Context): AppDatabase{
            if(INSTANCE != null){
                return INSTANCE!!
            } else{
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    REMINDER_DATABASE_NAME
                ).allowMainThreadQueries()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}