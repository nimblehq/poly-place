package co.co.nimblehq.showcases.poly.place.ui

import androidx.navigation.NamedNavArgument
import co.co.nimblehq.showcases.poly.place.ui.screens.restaurant.uimodel.Restaurant

const val KeyRestaurant = "restaurant"

sealed class AppDestination(val route: String = "") {

    open val arguments: List<NamedNavArgument> = emptyList()

    open var destination: String = route

    open var parcelableArgument: Pair<String, Any?> = "" to null

    object Up : AppDestination()

    object NearbyRestaurants : AppDestination("nearbyRestaurants")

    object RestaurantDetails : AppDestination("restaurantDetails") {
        fun addParcel(restaurant: Restaurant) = apply {
            parcelableArgument = KeyRestaurant to restaurant
        }
    }
}
