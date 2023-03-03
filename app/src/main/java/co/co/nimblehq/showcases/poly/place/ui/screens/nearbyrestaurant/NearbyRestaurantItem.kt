package co.co.nimblehq.showcases.poly.place.ui.screens.nearbyrestaurant

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.co.nimblehq.showcases.poly.place.R
import co.co.nimblehq.showcases.poly.place.ui.theme.*
import com.google.android.libraries.places.api.model.PlaceLikelihood

@Composable
fun NearbyRestaurantItem(
    restaurant: PlaceLikelihood? = null
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(AppTheme.dimensions.spacingSmallest)
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .clip(
                    RoundedCornerShape(
                        topStart = AppTheme.dimensions.spacingSmall,
                        topEnd = AppTheme.dimensions.spacingSmall
                    )
                ),
            painter = painterResource(id = R.drawable.im_restaurant_mock),
            contentDescription = null,
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            color = Color.White,
            fontSize = AppTheme.dimensions.textSizeNormal,
            textAlign = TextAlign.Center,
            text = "Dragon X",
        )
        Row(modifier = Modifier.fillMaxWidth()) {
            Icon(
                modifier = Modifier.size(16.dp),
                painter = painterResource(id = R.drawable.ic_location),
                contentDescription = null,
                tint = Color.White
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = AppTheme.dimensions.spacingSmall),
                color = White70,
                fontSize = AppTheme.dimensions.textSizeNormal,
                text = "222, Iron street",
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.size(16.dp),
                painter = painterResource(id = R.drawable.ic_compass),
                contentDescription = null,
                tint = Color.White
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = AppTheme.dimensions.spacingSmall),
                color = Green40,
                fontSize = AppTheme.dimensions.textSizeNormal,
                text = "50 m",
            )
        }
    }
}

@Preview
@Composable
private fun NearbyRestaurantItemPreview() {
    ComposeTheme {
        NearbyRestaurantItem()
    }
}
