package com.aradsheybak.telegrambottomnavigation.screens.chats

import com.aradsheybak.telegrambottomnavigation.data.ChatItem

fun sampleChats(): List<ChatItem> = listOf(
    ChatItem(1, "Amir", "Hey! Are you free today?", "09:12", unreadCount = 2),
    ChatItem(2, "Sara", "Sent a photo", "08:45"),
    ChatItem(3, "Dev Group", "PR merged 🎉", "Yesterday", unreadCount = 5),
    ChatItem(4, "Gym Buddy", "Let's train at 6", "Mon"),
    ChatItem(5, "Mom", "How are you?", "Sun"),
)