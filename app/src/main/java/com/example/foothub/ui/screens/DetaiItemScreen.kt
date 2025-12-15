package com.example.foothub.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.foothub.model.Player
import com.example.foothub.ui.components.FavoriteToggleButton

@Composable
fun DetailItemScreen(
    player: Player,
    onFavoriteToggle: (Player) -> Unit
) {
    var isFavorite by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Image(
            painter = rememberAsyncImagePainter(player.photoUrl),
            contentDescription = player.name,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )

        Text("Nombre: ${player.name}")
        Text("Equipo: ${player.team}")
        Text("Posición: ${player.position}")
        Text("Edad: ${player.age}")
        Text("Nacionalidad: ${player.nationality}")

        FavoriteToggleButton(
            isFavorite = isFavorite,
            onToggle = {
                isFavorite = !isFavorite
                onFavoriteToggle(player)
            }
        )
    }
}
