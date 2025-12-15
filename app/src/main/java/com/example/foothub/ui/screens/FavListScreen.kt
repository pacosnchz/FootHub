package com.example.foothub.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.foothub.model.Player
import com.example.foothub.ui.components.FavoriteToggleButton
import com.example.foothub.ui.components.FootHubCard

@Composable
fun FavListScreen(
    initialFavorites: List<Player>
) {
    // Estado interno de favoritos
    val favorites = remember { mutableStateListOf<Player>().apply { addAll(initialFavorites) } }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(favorites) { player ->
            FootHubCard(onClick = {}) { // No navegamos a detalle por ahora
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(player.photoUrl),
                        contentDescription = player.name,
                        modifier = Modifier.size(64.dp)
                    )
                    Column(modifier = Modifier.weight(1f)) {
                        Text(player.name)
                        Text("${player.team} • ${player.position}")
                    }
                    FavoriteToggleButton(
                        isFavorite = true,
                        onToggle = {
                            favorites.remove(player) // eliminar de favoritos
                        }
                    )
                }
            }
        }
    }
}
