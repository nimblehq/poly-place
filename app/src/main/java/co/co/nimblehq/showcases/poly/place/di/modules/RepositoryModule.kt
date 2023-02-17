package co.co.nimblehq.showcases.poly.place.di.modules

import co.co.nimblehq.showcases.poly.place.data.repository.RepositoryImpl
import co.co.nimblehq.showcases.poly.place.data.service.ApiService
import co.co.nimblehq.showcases.poly.place.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {

    @Provides
    fun provideRepository(apiService: ApiService): Repository = RepositoryImpl(apiService)
}
