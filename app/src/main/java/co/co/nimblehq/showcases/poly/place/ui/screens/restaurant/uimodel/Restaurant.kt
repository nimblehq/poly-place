package co.co.nimblehq.showcases.poly.place.ui.screens.restaurant.uimodel

import android.graphics.Bitmap

data class Restaurant(
    val id: String,
    val thumbnailImage: Bitmap,
    val name: String,
    val address: String,
    val distance: String,
)
