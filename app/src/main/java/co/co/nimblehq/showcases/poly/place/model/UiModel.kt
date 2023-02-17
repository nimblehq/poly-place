package co.co.nimblehq.showcases.poly.place.model

import co.co.nimblehq.showcases.poly.place.domain.model.Model

data class UiModel(
    val id: Int
)

fun Model.toUiModel() = UiModel(id = id ?: -1)
