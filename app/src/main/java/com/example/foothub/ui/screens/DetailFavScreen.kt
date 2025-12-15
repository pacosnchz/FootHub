package com.example.foothub.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.foothub.model.Player

@Composable
fun DetailFavScreen(
    player: Player
) {
    var comments by remember { mutableStateOf(listOf("Jugador muy habilidoso!", "Impresionante velocidad.")) }
    var newComment by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Text(player.name, style = MaterialTheme.typography.headlineMedium)
        Text("${player.team} • ${player.position}", style = MaterialTheme.typography.bodyMedium)

        // Lista de comentarios
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(comments) { comment ->
                Card(
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = comment,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }

        // Campo para añadir comentario + FAB
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            TextField(
                value = newComment,
                onValueChange = { newComment = it },
                placeholder = { Text("Escribe un comentario") },
                modifier = Modifier.weight(1f)
            )
            FloatingActionButton(
                onClick = {
                    if (newComment.isNotBlank()) {
                        comments = comments + newComment
                        newComment = ""
                    }
                }
            ) {
                Text("+")
            }
        }
    }
}
