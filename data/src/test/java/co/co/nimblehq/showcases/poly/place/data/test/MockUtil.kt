package co.co.nimblehq.showcases.poly.place.data.test

import co.co.nimblehq.showcases.poly.place.data.response.ErrorResponse
import io.mockk.every
import io.mockk.mockk
import okhttp3.ResponseBody
import retrofit2.HttpException
import retrofit2.Response

object MockUtil {

    val mockHttpException: HttpException
        get() {
            val response = mockk<Response<Any>>()
            val httpException = mockk<HttpException>()
            val responseBody = mockk<ResponseBody>()
            every { response.code() } returns 500
            every { response.message() } returns "message"
            every { response.errorBody() } returns responseBody
            every { httpException.code() } returns response.code()
            every { httpException.message() } returns response.message()
            every { httpException.response() } returns response
            every { responseBody.string() } returns "{\n" +
                    "  \"message\": \"message\"\n" +
                    "}"
            return httpException
        }

    val errorResponse = ErrorResponse(
        message = "message"
    )
}
