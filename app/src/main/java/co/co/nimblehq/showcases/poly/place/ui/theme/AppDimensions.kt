package co.co.nimblehq.showcases.poly.place.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class AppDimensions {
    // Custom dimensions here
    val spacingSmallest = 2.dp
    val spacingSmall = 8.dp
    val spacingNormal = 16.dp
    val spacingLarge = 24.dp
    val spacingHuge = 40.dp

    // Text size dimensions
    val textSizeNormal = 16.sp
    val textSizeToolbar = 34.sp

    // Image size dimensions
    val iconSizeNormal = 16.dp
    val iconSizeToolbar = 24.dp
}

internal val LocalAppDimensions = staticCompositionLocalOf { AppDimensions() }
