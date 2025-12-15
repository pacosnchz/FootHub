package com.example.foothub.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.foothub.model.Player
import com.example.foothub.ui.components.FavoriteToggleButton

@Composable
fun DetailItemScreen(
    player: Player,
    onFavoriteToggle: (Player) -> Unit
) {
    var isFavorite by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        // Tarjeta con información del jugador
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(6.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Nombre: ${player.name}", fontSize = 20.sp)
                Text("Equipo: ${player.team}", fontSize = 18.sp)
                Text("Posición: ${player.position}", fontSize = 18.sp)
                Text("Edad: ${player.age}", fontSize = 16.sp)
                Text("Nacionalidad: ${player.nationality}", fontSize = 16.sp)

                Spacer(modifier = Modifier.height(12.dp))

                // Imagen debajo de la información
                Image(
                    painter = rememberAsyncImagePainter(player.photoUrl),
                    contentDescription = player.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Botón de favorito
                FavoriteToggleButton(
                    isFavorite = isFavorite,
                    onToggle = {
                        isFavorite = !isFavorite
                        onFavoriteToggle(player)
                    }
                )
            }
        }
    }
}
