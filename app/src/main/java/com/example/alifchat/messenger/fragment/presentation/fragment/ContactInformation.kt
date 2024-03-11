package com.example.alifchat.messenger.fragment.presentation.fragment

import SharedViewModel
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import com.example.alifchat.R

class ContactInformation : Fragment() {
    private var Namefriend: String? = null
    private var Numberfriend: String? = null

    val sharedViewModel: SharedViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {



        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // получаем и присваиваем Аватарку
        val receivedImage = sharedViewModel.selectedImage
        val view = inflater.inflate(R.layout.fragment_contact_information, container, false)
        val avatarImageView: ImageView = view.findViewById(R.id.avatarImageView)
        avatarImageView.setImageResource(receivedImage)


        // получаем и присваиваем Имя
        val nameTextView = view.findViewById<TextView>(R.id.NameTextView)
        nameTextView.text = arguments?.getString("name")

        // получаем и присваиваем Номер тела
        val numberTextView = view.findViewById<TextView>(R.id.NumberTextView)
        numberTextView.text = arguments?.getString("number")


        val nazadImageView= view.findViewById<ImageView>(R.id.NazadImageView)
        nazadImageView.setOnClickListener {
            activity?.onBackPressed()
        }

        return view
    }

}