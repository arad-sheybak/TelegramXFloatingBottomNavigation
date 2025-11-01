package com.aradsheybak.telegrambottomnavigation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.aradsheybak.telegrambottomnavigation.navigation.SetupNavGraph
import com.aradsheybak.telegrambottomnavigation.navigation.bottomNavigation.GlassBottomNavigation

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            GlassBottomNavigation(navController = navController)
        },
        containerColor = Color.White
    ) {innerPadding ->
        Box(modifier = Modifier.fillMaxSize()
            .padding(innerPadding)
            .background(Color.White)) {
            SetupNavGraph(navController = navController)
        }
    }
}
