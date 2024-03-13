package com.example.alifchat.messenger.fragment.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alif.alifchat.messenger.fragment.presentation.model.ChatDetailModel
import com.example.alifchat.messenger.fragment.presentation.model.ChatModel
import com.example.alifchat.R

class ChatsAdapter(private val listener: OnItemClickListener) : RecyclerView.Adapter<ChatsAdapter.ViewHolder>() {


    private val items = ArrayList<ChatModel>()

    fun updateItems(items: List<ChatModel>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    // Интерфейс для обработки событий нажатия
    interface OnItemClickListener {


        fun onItemClick(item: ChatModel)
    }

    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        private val titleTextView = itemView.findViewById<TextView>(R.id.titleTextView)
        private val lastMessageTextView = itemView.findViewById<TextView>(R.id.lastMessageTextView)
        private val imageView_Avatar = itemView.findViewById<ImageView>(R.id.imageView_Avatar)

        fun bind(item: ChatModel) {
            imageView_Avatar.setImageResource(item.avatar)
            titleTextView.text = item.title
            lastMessageTextView.text = item.lastMessage
        }

        //
        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(items[position])
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.chat_item, parent, false)
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])



}