package co.co.nimblehq.showcases.poly.place.ui.screens.restaurant.nearby

import co.co.nimblehq.showcases.poly.place.domain.usecase.UseCase
import co.co.nimblehq.showcases.poly.place.model.UiModel
import co.co.nimblehq.showcases.poly.place.model.toUiModel
import co.co.nimblehq.showcases.poly.place.ui.AppDestination
import co.co.nimblehq.showcases.poly.place.ui.base.BaseViewModel
import co.co.nimblehq.showcases.poly.place.ui.screens.restaurant.uimodel.Restaurant
import co.co.nimblehq.showcases.poly.place.util.DispatchersProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class NearbyRestaurantsViewModel @Inject constructor(
    private val useCase: UseCase,
    dispatchers: DispatchersProvider
) : BaseViewModel(dispatchers) {

    private val _uiModels = MutableStateFlow<List<UiModel>>(emptyList())
    val uiModels: StateFlow<List<UiModel>>
        get() = _uiModels

    init {
        execute {
            showLoading()
            useCase()
                .catch {
                    _error.emit(it)
                }
                .collect { result ->
                    val uiModels = result.map { it.toUiModel() }
                    _uiModels.emit(uiModels)
                }
            hideLoading()
        }
    }

    fun navigateToRestaurantDetails(restaurant: Restaurant) {
        execute { _navigator.emit(AppDestination.RestaurantDetails.addParcel(restaurant)) }
    }
}
