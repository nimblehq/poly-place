package co.co.nimblehq.showcases.poly.place.domain.exceptions

import co.co.nimblehq.showcases.poly.place.domain.model.Error

object NoConnectivityException : RuntimeException()

data class ApiException(
    val error: Error?,
    val httpCode: Int,
    val httpMessage: String?
) : RuntimeException()
