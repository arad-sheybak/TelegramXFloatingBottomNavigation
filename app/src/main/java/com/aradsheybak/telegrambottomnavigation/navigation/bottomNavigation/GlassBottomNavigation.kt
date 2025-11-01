package com.aradsheybak.telegrambottomnavigation.navigation.bottomNavigation

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.aradsheybak.telegrambottomnavigation.R
import com.aradsheybak.telegrambottomnavigation.navigation.Screen
import kotlinx.coroutines.launch

@Composable
fun GlassBottomNavigation(navController: NavController){
    val items= listOf(
        BottomNavItem(Screen.Contacts.route, R.drawable.ic_contacts, "Contacts"),
        BottomNavItem(Screen.Chats.route, R.drawable.ic_chats, "Chats"),
        BottomNavItem(Screen.Calls.route, R.drawable.ic_calls, "Calls"),
        BottomNavItem(Screen.Settings.route, R.drawable.ic_settings, "Settings"),
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 34.dp, vertical = 24.dp)
            .shadow(10.dp, RoundedCornerShape(24.dp))
            .clip(RoundedCornerShape(24.dp))
            .background(Color.Black.copy(alpha = 1f))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            items.forEach { item ->
                val selected = item.route == currentRoute
                val interactionSource = remember { MutableInteractionSource() }

                val iconTint by animateColorAsState(
                    if (selected) colorResource(R.color.stroke_bttm_icns) else Color.White.copy(alpha = 1f)
                )
                val scope = rememberCoroutineScope()
                val scale = remember { Animatable(1f) }
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .clickable (
                            interactionSource = interactionSource,
                            indication = null
                        ){
                            scope.launch {
                                scale.animateTo(
                                    targetValue = 1.2f,
                                    animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing)
                                )
                                scale.animateTo(
                                    targetValue = 1f,
                                    animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing)
                                )
                            }

                            if (currentRoute != item.route) {
                                navController.navigate(item.route) {
                                    popUpTo(navController.graph.startDestinationId) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        },
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Icon(
                        painter = painterResource(id = item.iconRes),
                        contentDescription = "Chats",
                        tint = iconTint,
                        modifier = Modifier
                            .size(24.dp)
                            .graphicsLayer(
                                scaleX = scale.value,
                                scaleY = scale.value
                            )
                    )
                        Text(
                            text = item.label,
                            style = MaterialTheme.typography.labelSmall,
                            color = iconTint,

                        )
                }
            }
        }
    }
}