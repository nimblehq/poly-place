package co.co.nimblehq.showcases.poly.place.ui.theme

import androidx.compose.material.*
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

// Base colors here
val BlueDenim = Color(0xFF0060AE)
val Green40 = Color(0x660DF424)
val ViolentViolet89 = Color(0xE3201547)
val White70 = Color(0xB3FFFFFF)
val White20 = Color(0x33FFFFFF)

/**
 * Expand the final [Colors] class to provide more custom app colors.
 */
data class AppColors(
    val themeColors: Colors

    // Custom colors here
)

internal val LightColorPalette = AppColors(
    themeColors = lightColors()
)

internal val DarkColorPalette = AppColors(
    themeColors = darkColors()
)

internal val LocalAppColors = staticCompositionLocalOf { LightColorPalette }
