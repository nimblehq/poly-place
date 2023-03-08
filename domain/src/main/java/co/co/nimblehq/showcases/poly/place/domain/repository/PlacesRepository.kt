package co.co.nimblehq.showcases.poly.place.domain.repository

import co.co.nimblehq.showcases.poly.place.domain.model.Restaurant
import kotlinx.coroutines.flow.Flow

interface PlacesRepository {

    fun getNearbyRestaurants(): Flow<List<Restaurant>>
}
