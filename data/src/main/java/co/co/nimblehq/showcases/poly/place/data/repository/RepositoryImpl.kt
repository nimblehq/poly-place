package co.co.nimblehq.showcases.poly.place.data.repository

import co.co.nimblehq.showcases.poly.place.data.extensions.flowTransform
import co.co.nimblehq.showcases.poly.place.data.response.toModels
import co.co.nimblehq.showcases.poly.place.data.service.ApiService
import co.co.nimblehq.showcases.poly.place.domain.model.Model
import co.co.nimblehq.showcases.poly.place.domain.repository.Repository
import kotlinx.coroutines.flow.Flow

class RepositoryImpl constructor(
    private val apiService: ApiService
) : Repository {

    override fun getModels(): Flow<List<Model>> = flowTransform {
        apiService.getResponses().toModels()
    }
}
