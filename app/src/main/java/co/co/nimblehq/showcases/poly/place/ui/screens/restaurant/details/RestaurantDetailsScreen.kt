package co.co.nimblehq.showcases.poly.place.ui.screens.restaurant.details

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.hilt.navigation.compose.hiltViewModel
import co.co.nimblehq.showcases.poly.place.R
import co.co.nimblehq.showcases.poly.place.ui.AppDestination
import co.co.nimblehq.showcases.poly.place.ui.common.StartDrawableText
import co.co.nimblehq.showcases.poly.place.ui.screens.restaurant.uimodel.Restaurant
import co.co.nimblehq.showcases.poly.place.ui.theme.*
import co.co.nimblehq.showcases.poly.place.ui.theme.AppTheme.dimensions

@Composable
fun RestaurantDetailsScreen(
    viewModel: RestaurantDetailsViewModel = hiltViewModel(),
    navigator: (destination: AppDestination) -> Unit,
    restaurant: Restaurant?
) {

    restaurant?.let {
        RestaurantDetailsContent(
            restaurant = it,
            onBackButtonClicked = { navigator(AppDestination.Up) }
        )
    }
}

@Composable
private fun RestaurantDetailsContent(restaurant: Restaurant, onBackButtonClicked: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ViolentViolet)
            .padding(horizontal = dimensions.spacingNormal)
            .padding(top = dimensions.spacingHuge)
    ) {
        RestaurantDetailsToolbar(
            title = restaurant.name,
            onBackButtonClicked = onBackButtonClicked
        )
        RestaurantDetails(restaurant = restaurant)
    }
}

@Composable
private fun RestaurantDetailsToolbar(
    title: String,
    modifier: Modifier = Modifier,
    onBackButtonClicked: () -> Unit
) {
    Column(modifier) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painterResource(id = R.drawable.ic_back_arrow),
                contentDescription = null,
                modifier = Modifier
                    .size(dimensions.iconSizeToolbar)
                    .clickable { onBackButtonClicked() },
                tint = White
            )
            Text(
                text = title,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = dimensions.spacingLarge),
                color = White,
                fontSize = dimensions.textSizeToolbar
            )
        }
    }
}

@Composable
private fun RestaurantDetails(
    restaurant: Restaurant,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = dimensions.spacingNormal)
                .aspectRatio(0.94f),
            bitmap = restaurant.thumbnailImage.asImageBitmap(),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
        StartDrawableText(
            modifier = Modifier
                .padding(top = 28.dp)
                .fillMaxWidth(),
            iconResId = R.drawable.ic_address,
            textColor = White70,
            text = restaurant.address
        )
        StartDrawableText(
            modifier = Modifier
                .padding(top = 9.dp)
                .fillMaxWidth(),
            iconResId = R.drawable.ic_distance,
            textColor = Green40,
            text = restaurant.distance
        )
    }
}

@Preview
@Composable
private fun RestaurantDetailsPreview() {
    ComposeTheme {
        RestaurantDetailsContent(
            restaurant = Restaurant(
                id = "id",
                thumbnailImage = ContextCompat.getDrawable(
                    LocalContext.current,
                    R.drawable.im_restaurant_mock
                )!!.toBitmap(width = 600, height = 600),
                name = "Dragon X",
                address = "111, Dr. Strange street",
                distance = "50 m"
            ),
            onBackButtonClicked = {}
        )
    }
}
