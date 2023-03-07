package co.co.nimblehq.showcases.poly.place.ui.screens.restaurant.nearby

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import co.co.nimblehq.showcases.poly.place.R
import co.co.nimblehq.showcases.poly.place.ui.common.StartDrawableText
import co.co.nimblehq.showcases.poly.place.ui.screens.restaurant.uimodel.Restaurant
import co.co.nimblehq.showcases.poly.place.ui.theme.*
import co.co.nimblehq.showcases.poly.place.ui.theme.AppTheme.dimensions
import java.util.*

@Composable
fun NearbyRestaurantItem(
    restaurant: Restaurant
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(dimensions.spacingSmallest)
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1.1f)
                .clip(
                    RoundedCornerShape(
                        topStart = dimensions.spacingSmall,
                        topEnd = dimensions.spacingSmall
                    )
                ),
            bitmap = restaurant.thumbnailImage.asImageBitmap(),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            color = Color.White,
            fontSize = dimensions.textSizeNormal,
            textAlign = TextAlign.Center,
            text = restaurant.name
        )
        StartDrawableText(
            iconResId = R.drawable.ic_address,
            textColor = White70,
            text = restaurant.address
        )
        StartDrawableText(
            iconResId = R.drawable.ic_distance,
            textColor = Green40,
            text = restaurant.distance
        )
    }
}

@Preview
@Composable
private fun NearbyRestaurantItemPreview() {
    ComposeTheme {
        NearbyRestaurantItem(
            Restaurant(
                id = UUID.randomUUID().toString(),
                thumbnailImage = ContextCompat.getDrawable(
                    LocalContext.current,
                    R.drawable.bg_nearby_restaurants
                )!!.toBitmap(width = 600, height = 600),
                name = "Dragon X",
                address = "111, Dr. Strange street",
                distance = "50 m"
            )
        )
    }
}
