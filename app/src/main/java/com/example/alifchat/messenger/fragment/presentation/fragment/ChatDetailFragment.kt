package com.alif.alifchat.messenger.fragment.presentation.fragment

import SharedViewModel
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.util.Linkify
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.alifchat.messenger.fragment.presentation.adapter.ChatDetailAdapter
import com.alif.alifchat.messenger.fragment.presentation.model.ChatDetailModel
import com.example.alifchat.R
import com.example.alifchat.messenger.fragment.presentation.fragment.ContactInformation
import com.example.alifchat.messenger.fragment.presentation.fragment.FragmentImage

class ChatDetailFragment : Fragment(R.layout.fragment_chat_detail),
    ChatDetailAdapter.ItemClickListener {

  val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<RecyclerView>(R.id.chat_detail_recyclerView).apply {
            adapter = ChatDetailAdapter(
                listOf(
                    ChatDetailModel.FriendMessage(
                        mesage = "Looking forward to the trip.",
                        avatar = R.drawable.ic_bryin,
                        name = "Bryan",
                        number ="+14578574"
                    ),
                    ChatDetailModel.MyMessage(
                        message = "Same! Can’t wait.",
                        avatar = R.drawable.abdu,
                        name = "Abdu",
                        number ="+45484151"
                    ),
                    ChatDetailModel.FriendImageMessage(
                        description = "Looking forward to the trip.",
                        link = "https://www.okaytravel.ru/dostoprimechatelnosti/dostoprimechatelnosti-ssha/grand-kanon/",
                        avatar = R.drawable.ic_bryin,
                        image = R.drawable.ic_conyon,
                        name = "Bryan"
                    ),
                    ChatDetailModel.FriendMessage(
                        mesage = "What do you think?",
                        avatar = R.drawable.ic_bryin,
                        name = "Bryan",
                        number ="+14578574"
                    ),
                    ChatDetailModel.MyMessage(
                        message = "Oh yes this looks great!",
                        avatar = R.drawable.abdu,
                        name = "Abdu",
                        number ="+45484151"
                    ),
                    ChatDetailModel.FriendImageMessage(
                        description = "Look to the paris.",
                        link =  "https://ru.freepik.com/free-photos-vectors/paris",
                        avatar = R.drawable.ic_bryin,
                        image = R.drawable.paris,
                        name = "Bryan"
                    ),
                    ChatDetailModel.FriendMessage(
                        mesage = "What ?",
                        avatar = R.drawable.cindy_image,
                        name = "Cindy",
                        number ="+9277777777"
                    ),

                    ),
                this@ChatDetailFragment
            )
        }

    }

    override fun myMessageClicked(item: ChatDetailModel.MyMessage, position: Int ) {
        // Отправляем аватарку

            activity?.supportFragmentManager?.beginTransaction()
            sharedViewModel.selectedImage = item.avatar
            // Отправляем имя и номер
            val bundle = Bundle().apply {
                putString("name",item.name)
                putString("number",item.number)
            }

            val secondFragment = ContactInformation().apply {
                arguments = bundle
            }

            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.main_container, secondFragment)
                ?.addToBackStack(null)
                ?.commit()
    }

    override fun friendMessageClicked(

        item: ChatDetailModel.FriendMessage, position: Int,
        avatar: ImageView ) {
        activity?.supportFragmentManager?.beginTransaction()

        // Отправляем аватарку
        sharedViewModel.selectedImage = item.avatar
        // Отправляем имя и номер
        val bundle = Bundle().apply {
            putString("name",item.name)
            putString("number",item.number)
        }

        val secondFragment = ContactInformation().apply {
            arguments = bundle
        }

        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.main_container, secondFragment)
            ?.addToBackStack(null)
            ?.commit()

//        Toast.makeText(requireContext(), item.name , Toast.LENGTH_SHORT).show()
    }

    override fun friedMessageClicked(item: ChatDetailModel.FriendImageMessage, position: Int) {


        val url = item.link
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)

    }

    override fun friedImageMessageClicked(item: ChatDetailModel.FriendImageMessage, position: Int) {
        // Отправляем фото
        sharedViewModel.selectedImage = item.image

        // открываем второй фрагмент

        val secondFragment = FragmentImage()
        val fragmentManager = parentFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.main_container, secondFragment)
        transaction.addToBackStack(null)
        transaction.commit()

    }

//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//
//
////// ########## Здесь мы должны получить
////
////
////        // получаем и присваиваем Аватарку
////        val receivedImage = sharedViewModel.selectedImage
////        val view = inflater.inflate(R.layout.chat_detail_friend_message, container, false)
////        val avatarImageView: ImageView = view.findViewById(R.id.ImageView)
////        avatarImageView.setImageResource(receivedImage)
////
////
////        // получаем и присваиваем Имя
////        val nameTextView = view.findViewById<TextView>(R.id.textView)
////        nameTextView.text = arguments?.getString("name")
////
////// ########## Здесь мы должны получить
//
//        return inflater.inflate(R.layout.fragment_chat_detail, container, false)
//    }




}



