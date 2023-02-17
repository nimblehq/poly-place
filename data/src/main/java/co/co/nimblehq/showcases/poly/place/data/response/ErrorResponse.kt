package co.co.nimblehq.showcases.poly.place.data.response

import co.co.nimblehq.showcases.poly.place.domain.model.Error
import com.squareup.moshi.Json

data class ErrorResponse(
    @Json(name = "message")
    val message: String
)

internal fun ErrorResponse.toModel() = Error(message = message)
