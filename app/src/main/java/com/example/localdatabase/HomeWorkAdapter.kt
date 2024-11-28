package com.example.localdatabase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.localdatabase.databinding.ItemHomeworkBinding

class HomeworkAdapter(private val onItemClickCallback: OnItemClickCallback) :
    RecyclerView.Adapter<HomeworkAdapter.HomeworkViewHolder>() {

    private val listHomework = ArrayList<Homework>()

    interface OnItemClickCallback {
        fun onItemClicked(selectedHomework: Homework, position: Int)
    }

    fun setItems(items: List<Homework>) {
        listHomework.clear()
        listHomework.addAll(items)
        notifyDataSetChanged()
    }

    fun addItem(homework: Homework) {
        listHomework.add(homework)
        notifyItemInserted(listHomework.size - 1)
    }

    fun updateItem(position: Int, homework: Homework) {
        if (position in listHomework.indices) {
            listHomework[position] = homework
            notifyItemChanged(position)
        }
    }

    fun removeItem(position: Int) {
        if (position in listHomework.indices) {
            listHomework.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, listHomework.size)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeworkViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_homework, parent, false)
        return HomeworkViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeworkViewHolder, position: Int) {
        holder.bind(listHomework[position], position)
    }

    override fun getItemCount(): Int = listHomework.size

    inner class HomeworkViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemHomeworkBinding.bind(itemView)

        fun bind(homework: Homework, position: Int) {
            binding.tvItemTitle.text = homework.title
            binding.tvItemDate.text = homework.date
            binding.tvItemDescription.text = homework.description
            binding.cvItemHomework.setOnClickListener {
                onItemClickCallback.onItemClicked(homework, position)
            }
        }
    }
}
