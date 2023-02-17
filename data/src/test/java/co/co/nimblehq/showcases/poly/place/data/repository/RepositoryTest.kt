package co.co.nimblehq.showcases.poly.place.data.repository

import co.co.nimblehq.showcases.poly.place.data.response.Response
import co.co.nimblehq.showcases.poly.place.data.response.toModels
import co.co.nimblehq.showcases.poly.place.data.service.ApiService
import co.co.nimblehq.showcases.poly.place.domain.repository.Repository
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class RepositoryTest {

    private lateinit var mockService: ApiService
    private lateinit var repository: Repository

    private val response = Response(id = 1)

    @Before
    fun setUp() {
        mockService = mockk()
        repository = RepositoryImpl(mockService)
    }

    @Test
    fun `When request successful, it returns success`() = runTest {
        val expected = listOf(response)
        coEvery { mockService.getResponses() } returns expected

        repository.getModels().collect {
            it shouldBe expected.toModels()
        }
    }

    @Test
    fun `When request failed, it returns error`() = runTest {
        val expected = Throwable()
        coEvery { mockService.getResponses() } throws expected

        repository.getModels().catch {
            it shouldBe expected
        }.collect()
    }
}
