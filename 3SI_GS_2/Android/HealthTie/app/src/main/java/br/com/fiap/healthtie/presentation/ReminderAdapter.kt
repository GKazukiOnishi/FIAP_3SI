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
) : RecyclerView.Adapter<ReminderAdapter.ReminderItemViewHolder>(){

    private var reminderList : MutableList<ReminderModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReminderItemViewHolder {
       val binding = ViewReminderItemBinding.bind(
           LayoutInflater.from(parent.context).inflate(
               R.layout.view_reminder_item,
               parent,
               false
           )
       )
        return ReminderItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReminderItemViewHolder, position: Int) {
        holder.bindView(reminderList[position], position)
    }

    override fun getItemCount(): Int {
        return reminderList.size
    }

    fun setData(list: List<ReminderModel>){
        reminderList.clear()
        reminderList.addAll(list)
        notifyDataSetChanged()
    }

    inner class ReminderItemViewHolder(
        private val view: ViewReminderItemBinding
    ): RecyclerView.ViewHolder(view.root){

        fun bindView(reminderModel: ReminderModel, itemPosition: Int){
            view.reminderTitleValue.text = reminderModel.title
            view.reminderDescriptionValue.text = reminderModel.description
            view.reminderReminderDateTimeValue.text = reminderModel.formatReminderDateTime()

            view.reminderItemEditButton.setOnClickListener{
                onUpdateListener.invoke(reminderModel)
            }
        }
    }

}