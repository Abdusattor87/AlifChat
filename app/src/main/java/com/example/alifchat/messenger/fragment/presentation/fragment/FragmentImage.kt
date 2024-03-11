package com.example.alifchat.messenger.fragment.presentation.fragment

import SharedViewModel
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.activityViewModels
import com.example.alifchat.R

class FragmentImage : Fragment() {

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
        val receivedImage = sharedViewModel.selectedImage

        val view = inflater.inflate(R.layout.fragment_image, container, false)
        val imageView: ImageView = view.findViewById(R.id.ImageView1)
        imageView.setImageResource(receivedImage)


return view
    }
}