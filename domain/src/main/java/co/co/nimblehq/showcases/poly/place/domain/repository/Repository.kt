package co.co.nimblehq.showcases.poly.place.domain.repository

import co.co.nimblehq.showcases.poly.place.domain.model.Model
import kotlinx.coroutines.flow.Flow

interface Repository {

    fun getModels(): Flow<List<Model>>
}
