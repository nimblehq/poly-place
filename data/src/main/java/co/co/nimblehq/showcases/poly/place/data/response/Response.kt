package co.co.nimblehq.showcases.poly.place.data.response

import co.co.nimblehq.showcases.poly.place.domain.model.Model
import com.squareup.moshi.Json

data class Response(
    @Json(name = "id") val id: Int?
)

private fun Response.toModel() = Model(id = this.id)

fun List<Response>.toModels() = this.map { it.toModel() }
