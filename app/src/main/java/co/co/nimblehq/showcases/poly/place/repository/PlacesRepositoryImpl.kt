package co.co.nimblehq.showcases.poly.place.repository

import android.annotation.SuppressLint
import co.co.nimblehq.showcases.poly.place.domain.model.Restaurant
import co.co.nimblehq.showcases.poly.place.domain.repository.PlacesRepository
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.api.net.*
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.channels.trySendBlocking
import kotlinx.coroutines.flow.*
import timber.log.Timber
import javax.inject.Inject

class PlacesRepositoryImpl @Inject constructor(
    private val placesClient: PlacesClient
) : PlacesRepository {

    @SuppressLint("MissingPermission")
    override fun getNearbyRestaurants(): Flow<List<Restaurant>> = callbackFlow<List<Restaurant>> {
        val findCurrentPlaceRequest = FindCurrentPlaceRequest.newInstance(
            listOf(
                Place.Field.ID,
                Place.Field.PHOTO_METADATAS,
                Place.Field.NAME,
                Place.Field.ADDRESS
            )
        )
        placesClient.findCurrentPlace(findCurrentPlaceRequest)
            .addOnSuccessListener {
                val restaurant = it.placeLikelihoods.map { item ->
                    item.place.toRestaurant()
                }
                trySendBlocking(restaurant)
                close()
            }
            .addOnFailureListener {
                Timber.i(it)
                close(it)
            }
        awaitClose()
    }

    private fun Place.toRestaurant() = Restaurant(
        id = id.orEmpty(),
        thumbnailImage = null,
        name = name.orEmpty(),
        address = address.orEmpty(),
        distance = "50 m"
    )
}
