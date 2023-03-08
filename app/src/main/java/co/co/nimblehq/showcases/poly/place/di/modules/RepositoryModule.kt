package co.co.nimblehq.showcases.poly.place.di.modules

import android.content.Context
import co.co.nimblehq.showcases.poly.place.data.repository.RepositoryImpl
import co.co.nimblehq.showcases.poly.place.data.service.ApiService
import co.co.nimblehq.showcases.poly.place.domain.repository.PlacesRepository
import co.co.nimblehq.showcases.poly.place.domain.repository.Repository
import co.co.nimblehq.showcases.poly.place.repository.PlacesRepositoryImpl
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.net.PlacesClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {

    @Provides
    fun provideRepository(apiService: ApiService): Repository = RepositoryImpl(apiService)

    @Provides
    fun providePlacesRepository(placesClient: PlacesClient): PlacesRepository =
        PlacesRepositoryImpl(placesClient)

    @Provides
    @Singleton
    fun providePlacesClient(context: Context): PlacesClient = Places.createClient(context)
}
