package co.co.nimblehq.showcases.poly.place.domain.usecase

import co.co.nimblehq.showcases.poly.place.domain.model.Model
import co.co.nimblehq.showcases.poly.place.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UseCase @Inject constructor(private val repository: Repository) {

    operator fun invoke(): Flow<List<Model>> {
        return repository.getModels()
    }
}
