package co.co.nimblehq.showcases.poly.place.ui.screens.home

import androidx.activity.compose.setContent
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import co.co.nimblehq.showcases.poly.place.R
import co.co.nimblehq.showcases.poly.place.ui.AppDestination
import co.co.nimblehq.showcases.poly.place.ui.screens.MainActivity
import co.co.nimblehq.showcases.poly.place.ui.screens.nearbyrestaurant.NearbyRestaurantsScreen
import org.junit.*

class NearbyRestaurantsScreenTest {

    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    private var expectedAppDestination: AppDestination? = null

    @Before
    fun setUp() {
        composeRule.activity.setContent {
            NearbyRestaurantsScreen(
                navigator = { destination -> expectedAppDestination = destination }
            )
        }
    }

    @Test
    fun when_entering_the_Home_screen__it_shows_UI_correctly() {
        composeRule.run {
            onNodeWithText(activity.getString(R.string.app_name)).assertIsDisplayed()
        }
    }
}
