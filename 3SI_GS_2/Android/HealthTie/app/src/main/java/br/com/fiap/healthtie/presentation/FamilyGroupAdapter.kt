package br.com.fiap.healthtie.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.healthtie.R
import br.com.fiap.healthtie.databinding.ViewFamilyGroupItemBinding
import br.com.fiap.healthtie.domain.FamilyGroupModel

class FamilyGroupAdapter : RecyclerView.Adapter<FamilyGroupAdapter.FamilyGroupItemViewHolder>(){
    private var familyGroupList: MutableList<FamilyGroupModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FamilyGroupItemViewHolder{
        val binding = ViewFamilyGroupItemBinding.bind(
            LayoutInflater.from(parent.context).inflate(
                R.layout.view_family_group_item,
                parent,
                false
            )
        )
        return FamilyGroupItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FamilyGroupItemViewHolder,position: Int) {
        holder.bindView(familyGroupList[position])
    }

    override fun getItemCount(): Int {
        return familyGroupList.size
    }

    fun setData(list: List<FamilyGroupModel>){
        familyGroupList.clear()
        familyGroupList.addAll(list)
        notifyDataSetChanged()
    }

    inner class FamilyGroupItemViewHolder(
        private val view: ViewFamilyGroupItemBinding
    ): RecyclerView.ViewHolder(view.root){

        fun bindView(familyGroupModel: FamilyGroupModel){
            view.familyGroupTitleValue.text = familyGroupModel.namePerson
            view.familyGroupNoteValue.text = familyGroupModel.note
            view.familyGroupKinshipValue.text = familyGroupModel.kinship.title
        }
    }
}