package co.co.nimblehq.showcases.poly.place.ui.screens.nearbyrestaurant.uimodel

import android.graphics.Bitmap

data class Restaurant(
    val thumbnailImage: Bitmap,
    val name: String,
    val address: String,
    val distance: String,
)
