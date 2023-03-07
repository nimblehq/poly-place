package co.co.nimblehq.showcases.poly.place.util

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import timber.log.Timber

fun String.toBitmap(): Bitmap? {
    return try {
        val encodeByte: ByteArray = Base64.decode(this, Base64.DEFAULT)
        BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.size)
    } catch (e: Exception) {
        Timber.i(e)
        null
    }
}

