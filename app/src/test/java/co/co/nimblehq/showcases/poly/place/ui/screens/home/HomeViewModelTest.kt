package co.co.nimblehq.showcases.poly.place.ui.screens.home

import app.cash.turbine.test
import co.co.nimblehq.showcases.poly.place.domain.model.Model
import co.co.nimblehq.showcases.poly.place.domain.usecase.UseCase
import co.co.nimblehq.showcases.poly.place.model.toUiModel
import co.co.nimblehq.showcases.poly.place.test.CoroutineTestRule
import co.co.nimblehq.showcases.poly.place.util.DispatchersProvider
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.*
import org.junit.*

@ExperimentalCoroutinesApi
class HomeViewModelTest {

    @get:Rule
    val coroutinesRule = CoroutineTestRule()

    private val mockUseCase: UseCase = mockk()

    private lateinit var viewModel: NearbyRestaurantsViewModel

    private val models = listOf(Model(1), Model(2), Model(3))

    @Before
    fun setUp() {
        every { mockUseCase() } returns flowOf(models)

        initViewModel()
    }

    @Test
    fun `when loading models successfully, it shows the model list`() = runTest {
        viewModel.uiModels.test {
            expectMostRecentItem() shouldBe models.map { it.toUiModel() }
        }
    }

    @Test
    fun `when loading models failed, it shows the corresponding error`() = runTest {
        val error = Exception()
        every { mockUseCase() } returns flow { throw error }
        initViewModel(dispatchers = CoroutineTestRule(StandardTestDispatcher()).testDispatcherProvider)

        viewModel.error.test {
            advanceUntilIdle()

            expectMostRecentItem() shouldBe error
        }
    }

    @Test
    fun `When loading models, it shows and hides loading correctly`() = runTest {
        initViewModel(dispatchers = CoroutineTestRule(StandardTestDispatcher()).testDispatcherProvider)

        viewModel.showLoading.test {
            awaitItem() shouldBe false
            awaitItem() shouldBe true
            awaitItem() shouldBe false
        }
    }

    private fun initViewModel(dispatchers: DispatchersProvider = coroutinesRule.testDispatcherProvider) {
        viewModel = NearbyRestaurantsViewModel(
            mockUseCase,
            dispatchers
        )
    }
}
