package com.aradsheybak.telegrambottomnavigation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.aradsheybak.telegrambottomnavigation.screens.CallsScreen
import com.aradsheybak.telegrambottomnavigation.screens.chats.ChatsScreen
import com.aradsheybak.telegrambottomnavigation.screens.ContactsScreen
import com.aradsheybak.telegrambottomnavigation.screens.SettingsScreen

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
            ChatsScreen()
        }
        composable(route = Screen.Contacts.route) {
            ContactsScreen()
        }
        composable(route = Screen.Settings.route) {
            SettingsScreen()
        }

    }

}