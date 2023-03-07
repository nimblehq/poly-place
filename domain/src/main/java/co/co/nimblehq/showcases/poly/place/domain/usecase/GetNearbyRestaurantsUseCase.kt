package co.co.nimblehq.showcases.poly.place.domain.usecase

import co.co.nimblehq.showcases.poly.place.domain.model.Restaurant
import co.co.nimblehq.showcases.poly.place.domain.repository.PlacesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNearbyRestaurantsUseCase @Inject constructor(private val repository: PlacesRepository) {

    operator fun invoke(): Flow<List<Restaurant>> {
        return repository.getNearbyRestaurants()
    }
}
