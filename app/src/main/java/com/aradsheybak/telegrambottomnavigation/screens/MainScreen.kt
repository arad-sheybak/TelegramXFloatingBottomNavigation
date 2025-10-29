package com.aradsheybak.telegrambottomnavigation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.aradsheybak.telegrambottomnavigation.navigation.SetupNavGraph
import com.aradsheybak.telegrambottomnavigation.navigation.bottomNavigation.GlassBottomNavigation

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            GlassBottomNavigation(navController = navController)
        }
    ) {
        Box(modifier = Modifier.padding(0.dp)) {
            SetupNavGraph(navController = navController)
        }
    }
}
