package com.example.foothub.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foothub.R

@Composable
fun FootHubHome(
    onSobreClick: () -> Unit = {},
    onListClick: () -> Unit = {}
) {
    // Estado del scroll vertical
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)  // permite desplazamiento
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Image(
            painter = painterResource(id = R.drawable.ic_fh_logo),
            contentDescription = "Logo FootHub",
            modifier = Modifier.size(120.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "FootHub",
            style = MaterialTheme.typography.headlineLarge
        )

        Spacer(modifier = Modifier.height(8.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(6.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFE3F2FD)
            )
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(
                    "Explora equipos, jugadores, estadísticas y más gracias a API-Football.",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }

        Spacer(modifier = Modifier.height(40.dp))

        // Botón Sobre la aplicación
        Button(
            onClick = onSobreClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF7A1F))
        ) {
            Text("Sobre la aplicación", fontSize = 18.sp)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botón Lista de jugadores
        Button(
            onClick = onListClick,  // <- aquí solo llamas a la lambda
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF7A1F))
        ) {
            Text("Ver Lista de Jugadores", fontSize = 18.sp)
        }


        Spacer(modifier = Modifier.height(24.dp)) // espacio extra al final
    }
}
