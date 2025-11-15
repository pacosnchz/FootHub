package com.example.foothub

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Thread.sleep(1000)  // pequeña pausa Splash
        setContent {
            FootHubHome(
                onSobreClick = {
                    val intent = Intent(this, SobreActivity::class.java)
                    startActivity(intent)
                }
            )
        }
    }
}

@Composable
fun FootHubHome(onSobreClick: () -> Unit = {}) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // Logo / icono grande de la app
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

        // Card bonita con información
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

        // Botón principal
        Button(
            onClick = onSobreClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF7A1F),   // Fondo del botón
            )
        ) {
            Text("Sobre la aplicación", fontSize = 18.sp)
        }

    }
}

