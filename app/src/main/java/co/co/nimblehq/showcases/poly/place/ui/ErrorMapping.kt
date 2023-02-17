package co.co.nimblehq.showcases.poly.place.ui

import android.content.Context
import co.co.nimblehq.showcases.poly.place.R
import co.co.nimblehq.showcases.poly.place.domain.exceptions.ApiException

fun Throwable.userReadableMessage(context: Context): String {
    return when (this) {
        is ApiException -> error?.message
        else -> message
    } ?: context.getString(R.string.error_generic)
}
