package com.aradsheybak.telegrambottomnavigation.data

data class ChatItem(
    val id: Long,
    val name: String,
    val lastMessage: String,
    val time: String,
    val unreadCount: Int = 0,
    val avatarUrl: String? = null // optional,
)
