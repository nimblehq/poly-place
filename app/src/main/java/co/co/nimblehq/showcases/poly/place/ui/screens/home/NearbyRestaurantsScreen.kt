package co.co.nimblehq.showcases.poly.place.ui.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import co.co.nimblehq.showcases.poly.place.ui.theme.AppTheme.dimensions
import co.co.nimblehq.showcases.poly.place.ui.theme.ComposeTheme
import timber.log.Timber

@Composable
fun NearbyRestaurantsScreen(
    viewModel: NearbyRestaurantsViewModel = hiltViewModel(),
    navigator: (destination: AppDestination) -> Unit
) {
    val uiModels: List<UiModel> by viewModel.uiModels.collectAsState()

    NearbyRestaurantsContent(
        title = stringResource(id = R.string.app_name),
        uiModels = uiModels
    )
}

@Composable
fun NearbyRestaurantsToolbar() {
    ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
        val (title, iconEnd, divider) = createRefs()

        Text(
            text = stringResource(R.string.nearby_restaurants_title),
            color = Color.White,
            fontSize = dimensions.textSizeToolbar,
            modifier = Modifier
                .padding(horizontal = dimensions.spacingNormal)
                .constrainAs(title) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
        )

        Icon(
            painter = painterResource(id = R.drawable.ic_location),
            contentDescription = null,
            tint = Color.Blue,
            modifier = Modifier.size(25.dp)
        )


    }
}

@Composable
private fun NearbyRestaurantsContent(
    title: String,
    uiModels: List<UiModel>
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = title,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = dimensions.spacingNormal)
        )
    }
    Timber.d("Result : $uiModels")
}

@Preview(showSystemUi = true)
@Composable
private fun NearbyRestaurantsPreview() {
    ComposeTheme {
        NearbyRestaurantsContent(
            title = stringResource(id = R.string.app_name),
            uiModels = listOf(UiModel(1), UiModel(2), UiModel(3))
        )
    }
}
