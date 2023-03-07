package co.co.nimblehq.showcases.poly.place.ui.screens.restaurant.uimodel

import android.graphics.Bitmap
import co.co.nimblehq.showcases.poly.place.domain.model.Restaurant
import co.co.nimblehq.showcases.poly.place.util.toBitmap

data class RestaurantUiModel(
    val id: String,
    val thumbnailImage: Bitmap?,
    val name: String,
    val address: String,
    val distance: String
)

fun Restaurant.toRestaurantUiModel() = RestaurantUiModel(
    id = id,
    thumbnailImage = thumbnailImage?.toBitmap(),
    name = name,
    address = address,
    distance = distance
)
