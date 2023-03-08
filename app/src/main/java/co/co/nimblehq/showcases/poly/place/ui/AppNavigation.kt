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
                navigator = { destination -> navController.navigate(destination) },
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
