package br.com.fiap.healthtie.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.fiap.healthtie.domain.FAMILY_GROUP_MODEL_TABLE_NOME
import br.com.fiap.healthtie.domain.FamilyGroupModel

@Dao
interface FamilyGroupDAO {

    @Query("SELECT * FROM $FAMILY_GROUP_MODEL_TABLE_NOME ORDER BY id")
    suspend fun select(): List<FamilyGroupModel>
    @Query("SELECT * FROM $FAMILY_GROUP_MODEL_TABLE_NOME WHERE id == :idPeople")
    suspend fun selectById(idPeople: Int): FamilyGroupModel
    @Insert
    suspend fun insert(familyGroupModel: FamilyGroupModel)
}