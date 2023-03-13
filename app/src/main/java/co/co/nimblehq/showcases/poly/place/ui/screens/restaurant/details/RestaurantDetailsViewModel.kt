package co.co.nimblehq.showcases.poly.place.ui.screens.restaurant.details

import co.co.nimblehq.showcases.poly.place.ui.base.BaseViewModel
import co.co.nimblehq.showcases.poly.place.ui.screens.restaurant.uimodel.Restaurant
import co.co.nimblehq.showcases.poly.place.util.DispatchersProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import javax.inject.Inject

@HiltViewModel
class RestaurantDetailsViewModel @Inject constructor(
    dispatchers: DispatchersProvider
) : BaseViewModel(dispatchers) {

    private val _restaurant = MutableSharedFlow<Restaurant>()
    val restaurant: SharedFlow<Restaurant>
        get() = _restaurant
}
