package co.co.nimblehq.showcases.poly.place.ui.screens.restaurant.nearby

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.hilt.navigation.compose.hiltViewModel
import co.co.nimblehq.showcases.poly.place.R
import co.co.nimblehq.showcases.poly.place.model.UiModel
import co.co.nimblehq.showcases.poly.place.ui.AppDestination
import co.co.nimblehq.showcases.poly.place.ui.screens.restaurant.uimodel.Restaurant
import co.co.nimblehq.showcases.poly.place.ui.theme.*
import co.co.nimblehq.showcases.poly.place.ui.theme.AppTheme.dimensions
import timber.log.Timber

@Composable
fun NearbyRestaurantsScreen(
    viewModel: NearbyRestaurantsViewModel = hiltViewModel(),
    navigator: (destination: AppDestination) -> Unit
) {
    val uiModels: List<UiModel> by viewModel.uiModels.collectAsState()

    NearbyRestaurantsContent(
        uiModels = uiModels
    )
}

@Composable
private fun NearbyRestaurantsContent(
    uiModels: List<UiModel>
) {
    // Mock data for UI task
    // TODO: Remove this when implementing integrate task: https://github.com/nimblehq/poly-place/issues/32
    val mockRestaurants = arrayListOf(
        Restaurant(
            thumbnailImage = ContextCompat.getDrawable(
                LocalContext.current,
                R.drawable.im_restaurant_mock
            )!!.toBitmap(),
            name = "Dragon X",
            address = "111, Dr. Strange street",
            distance = "50 m"
        ),
        Restaurant(
            thumbnailImage = ContextCompat.getDrawable(
                LocalContext.current,
                R.drawable.im_restaurant_mock
            )!!.toBitmap(),
            name = "Dragon X",
            address = "111, Dr. Strange street",
            distance = "50 m"
        ),
        Restaurant(
            thumbnailImage = ContextCompat.getDrawable(
                LocalContext.current,
                R.drawable.im_restaurant_mock
            )!!.toBitmap(),
            name = "Dragon X",
            address = "111, Dr. Strange street",
            distance = "50 m"
        ),
        Restaurant(
            thumbnailImage = ContextCompat.getDrawable(
                LocalContext.current,
                R.drawable.im_restaurant_mock
            )!!.toBitmap(),
            name = "Dragon X",
            address = "111, Dr. Strange street",
            distance = "50 m"
        ),
        Restaurant(
            thumbnailImage = ContextCompat.getDrawable(
                LocalContext.current,
                R.drawable.im_restaurant_mock
            )!!.toBitmap(),
            name = "Dragon X",
            address = "111, Dr. Strange street",
            distance = "50 m"
        ),
        Restaurant(
            thumbnailImage = ContextCompat.getDrawable(
                LocalContext.current,
                R.drawable.im_restaurant_mock
            )!!.toBitmap(),
            name = "Dragon X",
            address = "111, Dr. Strange street",
            distance = "50 m"
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.bg_nearby_restaurants),
                contentScale = ContentScale.FillBounds
            )
    ) {
        NearbyRestaurantsToolbar()
        NearbyRestaurantList(mockRestaurants)
    }
    Timber.d("Result : $uiModels")
}

@Composable
private fun NearbyRestaurantsToolbar() {
    ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
        val (title, iconEnd, divider) = createRefs()

        val spacingNormal = dimensions.spacingNormal
        val spacingLarge = dimensions.spacingLarge
        val spacingHuge = dimensions.spacingHuge

        Text(
            modifier = Modifier
                .constrainAs(title) {
                    top.linkTo(parent.top, spacingHuge)
                    start.linkTo(parent.start, spacingNormal)
                },
            text = stringResource(R.string.nearby_restaurants_title),
            color = Color.White,
            fontSize = dimensions.textSizeToolbar
        )
        Icon(
            modifier = Modifier
                .size(dimensions.iconSizeToolbar)
                .constrainAs(iconEnd) {
                    end.linkTo(parent.end, spacingLarge)
                    centerVerticallyTo(title)
                },
            painter = painterResource(id = R.drawable.ic_target),
            contentDescription = null,
            tint = BlueDenim
        )
        Divider(
            modifier = Modifier
                .padding(
                    horizontal = dimensions.spacingNormal,
                    vertical = dimensions.spacingSmall
                )
                .constrainAs(divider) {
                    top.linkTo(title.bottom)
                    centerHorizontallyTo(parent)
                },
            color = White20
        )
    }
}

@Composable
private fun NearbyRestaurantList(
    restaurants: List<Restaurant>
) {
    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = dimensions.spacingNormal,
                end = dimensions.spacingNormal,
                top = dimensions.spacingNormal,
                bottom = dimensions.spacingHuge
            ),
        verticalArrangement = Arrangement.spacedBy(dimensions.spacingNormal),
        horizontalArrangement = Arrangement.spacedBy(dimensions.spacingNormal),
        columns = GridCells.Fixed(2)
    ) {
        items(restaurants.size) { index ->
            NearbyRestaurantItem(restaurants[index])
        }
    }
}

@Preview
@Composable
private fun NearbyRestaurantsPreview() {
    ComposeTheme {
        NearbyRestaurantsContent(
            uiModels = listOf(UiModel(1), UiModel(2), UiModel(3))
        )
    }
}
