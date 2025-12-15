package com.example.foothub.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.foothub.model.Player
import com.example.foothub.ui.components.FootHubCard

@Composable
fun ElemListScreen(
    players: List<Player>,
    onPlayerClick: (Player) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(players) { player ->
            FootHubCard(onClick = { onPlayerClick(player) }) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(player.photoUrl),
                        contentDescription = player.name,
                        modifier = Modifier.size(64.dp)
                    )
                    Column {
                        Text(player.name)
                        Text("${player.team} • ${player.position}")
                    }
                }
            }
        }
    }
}
