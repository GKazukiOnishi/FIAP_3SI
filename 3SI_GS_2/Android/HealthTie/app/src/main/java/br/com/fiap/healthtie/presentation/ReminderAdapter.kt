package br.com.fiap.healthtie.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.healthtie.R
import br.com.fiap.healthtie.databinding.ViewReminderItemBinding
import br.com.fiap.healthtie.domain.ReminderModel

class ReminderAdapter(
    private val onDeleteListener: (ReminderModel) -> Unit = {},
    private val onUpdateListener: (ReminderModel) -> Unit = {},
) : RecyclerView.Adapter<ReminderAdapter.CharacterItemViewHolder>(){

    private var reminderList : MutableList<ReminderModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterItemViewHolder {
       val binding = ViewReminderItemBinding.bind(
           LayoutInflater.from(parent.context).inflate(
               R.layout.view_reminder_item,
               parent,
               false
           )
       )
        return CharacterItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterItemViewHolder, position: Int) {
        holder.bindView(reminderList[position], position)
    }

    override fun getItemCount(): Int {
        return reminderList.size
    }
    fun setData(list: List<ReminderModel>){
        with(reminderList){
            clear()
            addAll(list)
        }
        notifyDataSetChanged()
    }
    inner class CharacterItemViewHolder(
        private val view: ViewReminderItemBinding
    ): RecyclerView.ViewHolder(view.root){

        fun bindView(reminderModel: ReminderModel, itemPosition: Int){
            view.reminderTitleValue.text = reminderModel.title
            view.reminderDescriptionValue.text = reminderModel.description
            view.reminderReminderDateTimeValue.text = reminderModel.formatReminderDateTime()


            //colocar o id do icone de dele de iconDelete
//            view.iconDelete.setOnClickListener{
//                onDeleteListener.invoke(reminderModel)
//            }

            //colocar o id do icone de dele de iconUpdate
//            view.iconUpdate.setOnClickListener{
//                onUpdateListener.invoke(reminderModel)
//            }
        }
    }
}