package co.co.nimblehq.showcases.poly.place.ui.screens.nearbyrestaurant

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import co.co.nimblehq.showcases.poly.place.R
import co.co.nimblehq.showcases.poly.place.model.UiModel
import co.co.nimblehq.showcases.poly.place.ui.AppDestination
import co.co.nimblehq.showcases.poly.place.ui.theme.*
import co.co.nimblehq.showcases.poly.place.ui.theme.AppTheme.dimensions
import com.google.android.libraries.places.api.model.PlaceLikelihood
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
fun NearbyRestaurantsToolbar() {
    ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
        val (title, iconEnd, divider) = createRefs()

        val spacingSmall = dimensions.spacingSmall
        val spacingNormal = dimensions.spacingNormal
        val spacingLarge = dimensions.spacingLarge
        val spacingHuge = dimensions.spacingHuge

        Text(
            text = stringResource(R.string.nearby_restaurants_title),
            color = Color.White,
            fontSize = dimensions.textSizeToolbar,
            modifier = Modifier
                .constrainAs(title) {
                    top.linkTo(parent.top, spacingHuge)
                    start.linkTo(parent.start, spacingNormal)
                }
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_target),
            contentDescription = null,
            tint = BlueDenim,
            modifier = Modifier
                .size(25.dp)
                .constrainAs(iconEnd) {
                    end.linkTo(parent.end, spacingLarge)
                    centerVerticallyTo(title)
                }
        )
        Divider(
            modifier = Modifier
                .padding(horizontal = spacingNormal, vertical = spacingSmall)
                .constrainAs(divider) {
                    top.linkTo(title.bottom)
                    centerHorizontallyTo(parent)
                },
            color = White20
        )
    }
}

@Composable
private fun NearbyRestaurantsContent(
    uiModels: List<UiModel>
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.bg_nearby_restaurants),
                contentScale = ContentScale.FillBounds
            )
    ) {
        NearbyRestaurantsToolbar()
        NearbyRestaurantList(emptyList())

    }
    Timber.d("Result : $uiModels")
}

@Composable
private fun NearbyRestaurantList(
    restaurants: List<PlaceLikelihood>
) {
    LazyVerticalGrid(
        verticalArrangement = Arrangement.spacedBy(dimensions.spacingNormal),
        horizontalArrangement = Arrangement.spacedBy(dimensions.spacingNormal),
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = dimensions.spacingNormal,
                end = dimensions.spacingNormal,
                top = dimensions.spacingNormal,
                bottom = dimensions.spacingHuge
            )
    ) {
        items(5) {
            NearbyRestaurantItem()
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
