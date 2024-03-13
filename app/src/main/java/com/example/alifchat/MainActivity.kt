package com.example.alifchat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.alifchat.messenger.fragment.presentation.fragment.ChatFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()



        // Для вызова фрагмента
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, ChatFragment())
            .commit()

    }
}