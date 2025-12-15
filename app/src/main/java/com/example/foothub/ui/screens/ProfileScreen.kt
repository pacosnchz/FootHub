package com.example.foothub.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen() {
    var isLoggedIn by remember { mutableStateOf(false) }
    var username by remember { mutableStateOf("Invitado") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Perfil del usuario", style = MaterialTheme.typography.headlineMedium)

        Text(
            text = "Usuario: $username",
            fontSize = 18.sp
        )

        Button(onClick = {
            if (!isLoggedIn) {
                // Simulación login
                username = "UsuarioDemo"
                isLoggedIn = true
            } else {
                // Simulación logout
                username = "Invitado"
                isLoggedIn = false
            }
        }) {
            Text(if (isLoggedIn) "Cerrar sesión" else "Iniciar sesión")
        }
    }
}
