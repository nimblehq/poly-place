package co.co.nimblehq.showcases.poly.place.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import co.co.nimblehq.showcases.poly.place.ui.AppNavigation
import co.co.nimblehq.showcases.poly.place.ui.theme.ComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                AppNavigation()
            }
        }
    }
}
