package com.example.foothub.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.foothub.R

// ----------------------
//  PALETA DE COLORES
// ----------------------

val OrangePrimary = Color(0xFFFF7A1F)      // Color principal basado en el logo
val OrangeContainer = Color(0xFFFFB68A)    // Variante suave (obligatoria)
val BlueLight = Color(0xFFE3F2FD)          // Azul pastel ya usado
val BlueSecondary = Color(0xFF4A90E2)      // Color secundario personalizado
val GreenTertiary = Color(0xFF3DDC84)      // Verde suave (terciario)
val ErrorRed = Color(0xFFD32F2F)

// ----------------------
//  TIPOGRAFÍAS
// ----------------------

val Montserrat = FontFamily(
    Font(R.font.montserrat_regular),
    Font(R.font.montserrat_bold, weight = FontWeight.Bold)
)

val Inter = FontFamily(
    Font(R.font.inter_regular),
    Font(R.font.inter_medium, weight = FontWeight.Medium)
)

val FootHubTypography = Typography(
    headlineLarge = Typography().headlineLarge.copy(fontFamily = Montserrat),
    titleMedium = Typography().titleMedium.copy(fontFamily = Montserrat),
    bodyLarge = Typography().bodyLarge.copy(fontFamily = Inter),
    bodyMedium = Typography().bodyMedium.copy(fontFamily = Inter)
)

// ----------------------
//  ESQUEMA DE COLORES
// ----------------------

private val LightColorScheme = lightColorScheme(
    primary = OrangePrimary,
    onPrimary = Color.White,
    primaryContainer = OrangeContainer,
    onPrimaryContainer = Color.Black,

    secondary = BlueSecondary,
    onSecondary = Color.White,
    secondaryContainer = BlueLight,
    onSecondaryContainer = Color.Black,

    tertiary = GreenTertiary,
    error = ErrorRed,

    background = Color.White,
    surface = Color.White
)

private val DarkColorScheme = darkColorScheme(
    primary = OrangePrimary,
    onPrimary = Color.Black,
    primaryContainer = OrangeContainer,

    secondary = BlueSecondary,
    tertiary = GreenTertiary,

    background = Color(0xFF121212),
    surface = Color(0xFF1E1E1E)
)

// ----------------------
//  THEME FINAL
// ----------------------

@Composable
fun FootHubTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colors,
        typography = FootHubTypography,
        content = content
    )
}
