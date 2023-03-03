package co.co.nimblehq.showcases.poly.place.ui

import androidx.navigation.*

sealed class AppDestination(val route: String = "") {

    open val arguments: List<NamedNavArgument> = emptyList()

    open var destination: String = route

    object Up : AppDestination()

    object NearbyRestaurants : AppDestination("nearby_restaurants")
}
