package com.example.alifchat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alif.alifchat.messenger.fragment.presentation.fragment.ChatDetailFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, ChatDetailFragment())
            .commit()

    }
}