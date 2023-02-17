package co.co.nimblehq.showcases.poly.place.data.extensions

import co.co.nimblehq.showcases.poly.place.data.response.ErrorResponse
import co.co.nimblehq.showcases.poly.place.data.response.toModel
import co.co.nimblehq.showcases.poly.place.data.service.providers.MoshiBuilderProvider
import co.co.nimblehq.showcases.poly.place.domain.exceptions.ApiException
import co.co.nimblehq.showcases.poly.place.domain.exceptions.NoConnectivityException
import com.squareup.moshi.JsonDataException
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import java.io.InterruptedIOException
import java.net.UnknownHostException
import kotlin.experimental.ExperimentalTypeInference

@Suppress("TooGenericExceptionCaught")
@OptIn(ExperimentalTypeInference::class)
fun <T> flowTransform(@BuilderInference block: suspend FlowCollector<T>.() -> T) = flow {
    val result = try {
        block()
    } catch (exception: Exception) {
        throw exception.mapError()
    }
    emit(result)
}

private fun Throwable.mapError(): Throwable {
    return when (this) {
        is UnknownHostException,
        is InterruptedIOException -> NoConnectivityException
        is HttpException -> {
            val errorResponse = parseErrorResponse(response())
            ApiException(
                errorResponse?.toModel(),
                code(),
                message()
            )
        }
        else -> this
    }
}

private fun parseErrorResponse(response: Response<*>?): ErrorResponse? {
    val jsonString = response?.errorBody()?.string()
    return try {
        val moshi = MoshiBuilderProvider.moshiBuilder.build()
        val adapter = moshi.adapter(ErrorResponse::class.java)
        adapter.fromJson(jsonString.orEmpty())
    } catch (exception: IOException) {
        null
    } catch (exception: JsonDataException) {
        null
    }
}
