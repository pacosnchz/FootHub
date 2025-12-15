package com.example.foothub.ui.navigation

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.foothub.SobrePantalla
import com.example.foothub.model.Player
import com.example.foothub.repository.PlayerRepository
import com.example.foothub.ui.components.FootHubCard
import com.example.foothub.ui.screens.*
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.foundation.layout.Row

@Composable
fun AppNavigation(windowSizeClass: WindowSizeClass) {
    val navController: NavHostController = rememberNavController()
    val widthSize = windowSizeClass.widthSizeClass

    NavHost(navController = navController, startDestination = "home") {

        // ============================
        // Pantalla de bienvenida
        // ============================
        composable("home") {
            FootHubHome(
                onSobreClick = { navController.navigate("about") },
                onListClick = { navController.navigate("elemList") }  // <- esto activa la lista
            )
        }




        // ============================
        // ElemListScreen adaptativa
        // ============================
        composable("elemList") {
            val isCompact = widthSize == WindowWidthSizeClass.Compact

            if (isCompact) {
                ElemListScreen(players = PlayerRepository.players) { player ->
                    navController.currentBackStackEntry?.savedStateHandle?.set("player", player)
                    navController.navigate("detail")
                }
            } else if (PlayerRepository.players.isNotEmpty()) {
                var selectedPlayer by remember { mutableStateOf(PlayerRepository.players.first()) }
                Row(modifier = Modifier.fillMaxSize()) {
                    LazyColumn(
                        modifier = Modifier.weight(1f).fillMaxHeight(),
                        contentPadding = PaddingValues(16.dp)
                    ) {
                        items(PlayerRepository.players) { player ->
                            FootHubCard(onClick = { selectedPlayer = player }) {
                                Text(player.name)
                                Text("${player.team} • ${player.position}")
                            }
                        }
                    }

                    DetailItemScreen(player = selectedPlayer) {}
                }
            }
        }






        // ============================
        // DetailItemScreen compact
        // ============================
        composable("detail") {
            val player = navController.previousBackStackEntry?.savedStateHandle?.get<Player>("player")
            player?.let {
                DetailItemScreen(player = it) {}
            }
        }

        // ============================
        // FavListScreen
        // ============================
        composable("favorites") {
            FavListScreen(initialFavorites = PlayerRepository.players.take(2))
        }

        // ============================
        // DetailFavScreen
        // ============================
        composable("detailFav") {
            val player = navController.previousBackStackEntry?.savedStateHandle?.get<Player>("player")
            player?.let {
                DetailFavScreen(player = it)
            }
        }

        // ============================
        // ProfileScreen
        // ============================
        composable("profile") {
            ProfileScreen()
        }

        // ============================
        // AboutScreen / SobrePantalla
        // ============================
        composable("about") {
            val context = LocalContext.current
            SobrePantalla(
                onMailClick = {
                    val intent = Intent(Intent.ACTION_SENDTO).apply {
                        data = Uri.parse("mailto:developer@foothub.com")
                        putExtra(Intent.EXTRA_SUBJECT, "Información sobre FootHub")
                        putExtra(Intent.EXTRA_TEXT, "Hola, quiero saber más sobre FootHub.")
                    }
                    context.startActivity(intent)
                }
            )
        }

    }
}
