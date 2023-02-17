package co.co.nimblehq.showcases.poly.place.data.service.providers

import co.co.nimblehq.showcases.poly.place.data.service.ApiService
import retrofit2.Retrofit

object ApiServiceProvider {

    fun getApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}
