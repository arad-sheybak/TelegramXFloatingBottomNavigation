package com.aradsheybak.telegrambottomnavigation.navigation.bottomNavigation

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val route: String,
    @DrawableRes val iconRes: Int,
    val label: String
)
