package com.example.alifchat.messenger.fragment.presentation.fragment

import SharedViewModel
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.alif.alifchat.messenger.fragment.presentation.fragment.ChatDetailFragment
import com.example.alifchat.R
import com.example.alifchat.messenger.fragment.presentation.adapter.ChatsAdapter
import com.example.alifchat.messenger.fragment.presentation.model.ChatModel

class ChatFragment : Fragment(R.layout.fragment_chats), ChatsAdapter.OnItemClickListener {
    val sharedViewModel: SharedViewModel by activityViewModels()

    private val recyclerView by lazy { requireView().findViewById<RecyclerView>(R.id.recyclerView) }
    private val adapter = ChatsAdapter(this)

    private val data = listOf(
        ChatModel(R.drawable.ic_bryin,"Bryan", "What do you think?"),
        ChatModel(R.drawable.cindy_image,"Kari", "Looks great!"),
        ChatModel(R.drawable.ic_diana,"Diana", "Lunch on Monday?"),
        ChatModel(R.drawable.ic_ben,"Ben", "You sent a photo."),
        ChatModel(R.drawable.ic_naomi,"Naomi", "Naomi sent a photo."),
        ChatModel(R.drawable.ic_alicia,"Alicia", "See you at 8."),
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.adapter = adapter
        adapter.updateItems(data)
        view.findViewById<EditText>(R.id.searchEditText).apply {
            background = null
            doAfterTextChanged {
                filterChats(it)
            }
        }
    }

    private fun filterChats(query: Editable?) {
        query?.let {
            if (it.isNotEmpty()) {
                val searchQuery = query.toString().lowercase()
                adapter.updateItems(data.filter {
                    it.title.lowercase().contains(searchQuery) ||
                            it.lastMessage.lowercase().contains(searchQuery)
                })
            } else adapter.updateItems(data)
        }
    }



    override fun onItemClick(item: ChatModel) {
        activity?.supportFragmentManager?.beginTransaction()






//         открываем второй фрагмент

        val secondFragment = ChatDetailFragment()
        val fragmentManager = parentFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.main_container, secondFragment)
        transaction.addToBackStack(null)
        transaction.commit()

//        Toast.makeText(context, item.title, Toast.LENGTH_SHORT).show()
    }


}