package com.aradsheybak.telegrambottomnavigation.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.aradsheybak.telegrambottomnavigation.screens.CallsScreen
import com.aradsheybak.telegrambottomnavigation.screens.chats.ChatsScreen
import com.aradsheybak.telegrambottomnavigation.screens.ContactsScreen
import com.aradsheybak.telegrambottomnavigation.screens.SettingsScreen
import com.aradsheybak.telegrambottomnavigation.screens.chats.sampleChats

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Chats.route
    ) {
        composable(route = Screen.Calls.route) {
            CallsScreen()
        }
        composable(route = Screen.Chats.route) {
            val chats = sampleChats()

            ChatsScreen(
                chats = chats,
                onChatClick = { chat ->
                    Log.e("chatItemClicked", "Yes")
                })
        }
        composable(route = Screen.Contacts.route) {
            ContactsScreen()
        }
        composable(route = Screen.Settings.route) {
            SettingsScreen()
        }

    }

}