package com.aradsheybak.telegrambottomnavigation.navigation

sealed class Screen(val route: String) {
    object Calls:Screen("calls")
    object Contacts:Screen("contacts")
    object Chats:Screen("chats")
    object Settings:Screen("settings")

}