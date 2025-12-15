package com.example.foothub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import com.example.foothub.ui.theme.FootHubTheme
import com.example.foothub.ui.navigation.AppNavigation

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Pausa breve para SplashScreen
        Thread.sleep(1000)

        setContent {
            // Calculamos tamaño de ventana para automatizar layout
            val windowSizeClass = calculateWindowSizeClass(this)

            FootHubTheme {
                // Navegación adaptativa según tamaño de ventana
                AppNavigation(windowSizeClass = windowSizeClass)
            }
        }
    }
}
