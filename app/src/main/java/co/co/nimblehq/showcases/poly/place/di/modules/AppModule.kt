package co.co.nimblehq.showcases.poly.place.di.modules

import co.co.nimblehq.showcases.poly.place.util.DispatchersProvider
import co.co.nimblehq.showcases.poly.place.util.DispatchersProviderImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideDispatchersProvider(): DispatchersProvider {
        return DispatchersProviderImpl()
    }
}
