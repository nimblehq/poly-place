package co.co.nimblehq.showcases.poly.place.ui.screens.restaurant.nearby

import android.Manifest
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.hilt.navigation.compose.hiltViewModel
import co.co.nimblehq.showcases.poly.place.BuildConfig
import co.co.nimblehq.showcases.poly.place.R
import co.co.nimblehq.showcases.poly.place.model.UiModel
import co.co.nimblehq.showcases.poly.place.ui.AppDestination
import co.co.nimblehq.showcases.poly.place.ui.common.Toaster
import co.co.nimblehq.showcases.poly.place.ui.screens.restaurant.uimodel.Restaurant
import co.co.nimblehq.showcases.poly.place.ui.theme.*
import co.co.nimblehq.showcases.poly.place.ui.theme.AppTheme.dimensions
import com.google.accompanist.permissions.*
import timber.log.Timber
import java.util.*

private const val RESTAURANTS_GRID_COLUMNS = 2

@Composable
fun NearbyRestaurantsScreen(
    viewModel: NearbyRestaurantsViewModel = hiltViewModel(),
    navigator: (destination: AppDestination) -> Unit,
    onGrantedLocationPermission: () -> Unit
) {
    val uiModels: List<UiModel> by viewModel.uiModels.collectAsState()

    LocationPermission(onGrantedLocationPermission, uiModels)
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun LocationPermission(
    onGrantedLocationPermission: () -> Unit,
    uiModels: List<UiModel>
) {
    val locationPermissionState = rememberPermissionState(
        Manifest.permission.ACCESS_FINE_LOCATION
    )

    if (locationPermissionState.status.isGranted) {
        onGrantedLocationPermission()
        NearbyRestaurantsContent(uiModels = uiModels)
    } else {
        val locationPermissionResId = if (locationPermissionState.status.shouldShowRationale) {
            R.string.location_permission_rationale
        } else {
            R.string.location_permission_is_required
        }
        Toaster(LocalContext.current).display(stringResource(id = locationPermissionResId))

        LaunchedEffect(Unit) {
            locationPermissionState.launchPermissionRequest()
        }
    }
}

@Composable
private fun NearbyRestaurantsContent(
    uiModels: List<UiModel>
) {
    // Mock data for UI task
    // TODO: Remove this when implementing integrate task: https://github.com/nimblehq/poly-place/issues/32
    val mockRestaurants = arrayListOf(
        Restaurant(
            id = UUID.randomUUID().toString(),
            thumbnailImage = ContextCompat.getDrawable(
                LocalContext.current,
                R.drawable.im_restaurant_mock
            )!!.toBitmap(width = 600, height = 600),
            name = "Dragon X",
            address = "111, Dr. Strange street",
            distance = "50 m"
        ),
        Restaurant(
            id = UUID.randomUUID().toString(),
            thumbnailImage = ContextCompat.getDrawable(
                LocalContext.current,
                R.drawable.im_restaurant_mock
            )!!.toBitmap(width = 600, height = 600),
            name = "Dragon X",
            address = "111, Dr. Strange street",
            distance = "50 m"
        ),
        Restaurant(
            id = UUID.randomUUID().toString(),
            thumbnailImage = ContextCompat.getDrawable(
                LocalContext.current,
                R.drawable.im_restaurant_mock
            )!!.toBitmap(width = 600, height = 600),
            name = "Dragon X",
            address = "111, Dr. Strange street",
            distance = "50 m"
        ),
        Restaurant(
            id = UUID.randomUUID().toString(),
            thumbnailImage = ContextCompat.getDrawable(
                LocalContext.current,
                R.drawable.im_restaurant_mock
            )!!.toBitmap(width = 600, height = 600),
            name = "Dragon X",
            address = "111, Dr. Strange street",
            distance = "50 m"
        ),
        Restaurant(
            id = UUID.randomUUID().toString(),
            thumbnailImage = ContextCompat.getDrawable(
                LocalContext.current,
                R.drawable.im_restaurant_mock
            )!!.toBitmap(width = 600, height = 600),
            name = "Dragon X",
            address = "111, Dr. Strange street",
            distance = "50 m"
        ),
        Restaurant(
            id = UUID.randomUUID().toString(),
            thumbnailImage = ContextCompat.getDrawable(
                LocalContext.current,
                R.drawable.im_restaurant_mock
            )!!.toBitmap(width = 600, height = 600),
            name = "Dragon X",
            address = "111, Dr. Strange street",
            distance = "50 m"
        )
    )

    Scaffold(
        bottomBar = {
            BottomAppBar(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(bottom = dimensions.spacingSmall),
                backgroundColor = ViolentViolet89,
                elevation = 0.dp
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.White,
                    fontSize = dimensions.textSizeNormal,
                    text = "${stringResource(id = R.string.app_version)} ${BuildConfig.VERSION_NAME}",
                    textAlign = TextAlign.Center
                )
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .paint(
                    painter = painterResource(id = R.drawable.bg_nearby_restaurants),
                    contentScale = ContentScale.FillBounds
                )
        ) {
            NearbyRestaurantsToolbar()
            NearbyRestaurantList(mockRestaurants)
        }
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
            .fillMaxSize()
            .padding(dimensions.spacingNormal),
        verticalArrangement = Arrangement.spacedBy(dimensions.spacingNormal),
        horizontalArrangement = Arrangement.spacedBy(dimensions.spacingNormal),
        columns = GridCells.Fixed(RESTAURANTS_GRID_COLUMNS)
    ) {
        items(
            items = restaurants,
            key = { it.id }
        ) { item ->
            NearbyRestaurantItem(item)
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
