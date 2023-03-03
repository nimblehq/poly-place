package co.co.nimblehq.showcases.poly.place.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class AppDimensions {
    // Custom dimensions here
    val spacingNormal = 16.dp

    // Text size dimensions
    val textSizeToolbar = 34.sp
}

internal val LocalAppDimensions = staticCompositionLocalOf { AppDimensions() }
