package co.co.nimblehq.showcases.poly.place.data.service

import co.co.nimblehq.showcases.poly.place.data.response.Response
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getResponses(): List<Response>
}
