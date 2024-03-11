package com.alif.alifchat.messenger.fragment.presentation.model

import androidx.annotation.DrawableRes

sealed class ChatDetailModel {

    data class MyMessage(val message: String, @DrawableRes val avatar: Int,val name: String, val number: String) : ChatDetailModel()

    data class FriendMessage(val mesage: String, @DrawableRes val avatar: Int,val name: String, val number: String) : ChatDetailModel()

    data class FriendImageMessage(
        @DrawableRes val avatar: Int,
        @DrawableRes val image: Int,
        val description: String,
        val link: String,
        val name: String
    ) : ChatDetailModel()

}