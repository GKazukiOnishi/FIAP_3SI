package br.com.fiap.healthtie.domain

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

const val FAMILY_GROUP_MODEL_TABLE_NAME = "familyGroupTable"

@Entity(tableName = FAMILY_GROUP_MODEL_TABLE_NAME)
@Parcelize
data class FamilyGroupModel(

    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    @ColumnInfo val namePerson: String,
    @ColumnInfo val note: String,
    @ColumnInfo val kinship: FamilyGroupKindship,

) : Parcelable
