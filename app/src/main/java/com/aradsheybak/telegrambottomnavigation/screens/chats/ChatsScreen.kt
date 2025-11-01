package com.aradsheybak.telegrambottomnavigation.screens.chats

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aradsheybak.telegrambottomnavigation.data.ChatItem

@Composable
fun ChatsScreen(
    chats: List<ChatItem>,
    onChatClick: (ChatItem) -> Unit
) {
    Log.e("chatSize",chats.size.toString())
    if (chats.isEmpty()) {
        // Empty state
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                "No chats yet",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Black
            )
        }
        return
    }else{
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(chats, key = {it.id}){ chat->
                ChatRow(item = chat, onClick = onChatClick)
                Divider(color = MaterialTheme.colorScheme.surfaceVariant, thickness = 0.5.dp)
            }
        }
    }


}

@Preview(showBackground = true)
@Composable
fun ChatsScreenPreview() {
    ChatsScreen(chats = sampleChats(), onChatClick = {})

}