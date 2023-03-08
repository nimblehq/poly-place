package co.co.nimblehq.showcases.poly.place.ui

import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.*
import co.co.nimblehq.showcases.poly.place.ui.screens.restaurant.details.RestaurantDetailsScreen
import co.co.nimblehq.showcases.poly.place.ui.screens.restaurant.nearby.NearbyRestaurantsScreen
import co.co.nimblehq.showcases.poly.place.ui.screens.restaurant.uimodel.Restaurant

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController(),
    startDestination: String = AppDestination.NearbyRestaurants.destination
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(AppDestination.NearbyRestaurants) {
            NearbyRestaurantsScreen(
                navigator = { destination -> navController.navigate(destination, destination.parcelableArgument) },
                onGrantedLocationPermission = { /* TODO: Call Places SDK in https://github.com/nimblehq/poly-place/issues/32 */ }
            )
        }

        composable(AppDestination.RestaurantDetails) {
            RestaurantDetailsScreen(
                navigator = { destination -> navController.navigate(destination) },
                restaurant = navController.previousBackStackEntry?.savedStateHandle
                    ?.get<Restaurant>(KeyRestaurant)
            )
        }
    }
}

private fun NavGraphBuilder.composable(
    destination: AppDestination,
    deepLinks: List<NavDeepLink> = emptyList(),
    content: @Composable (NavBackStackEntry) -> Unit
) {
    composable(
        route = destination.route,
        arguments = destination.arguments,
        deepLinks = deepLinks,
        content = content
    )
}

private fun NavHostController.navigate(appDestination: AppDestination) {
    when (appDestination) {
        is AppDestination.Up -> navigateUp()
        else -> navigate(route = appDestination.destination)
    }
}

/**
 * Navigate to provided [AppDestination] with a Pair of key value String and Data [parcel]
 * Caution to use this method. This method use savedStateHandle to store the Parcelable data.
 * When previousBackstackEntry is popped out from navigation stack, savedStateHandle will return null and cannot retrieve data.
 * eg.Login -> Home, the Login screen will be popped from the back-stack on logging in successfully.
 */
private fun NavHostController.navigate(appDestination: AppDestination, parcel: Pair<String, Any?>? = null) {
    when (appDestination) {
        is AppDestination.Up -> navigateUp()
        else -> {
            parcel?.let { (key, value) ->
                currentBackStackEntry?.savedStateHandle?.set(key, value)
            }
            navigate(route = appDestination.destination)
        }
    }
}
