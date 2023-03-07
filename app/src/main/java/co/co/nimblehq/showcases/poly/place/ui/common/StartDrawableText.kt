package co.co.nimblehq.showcases.poly.place.ui.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import co.co.nimblehq.showcases.poly.place.R
import co.co.nimblehq.showcases.poly.place.ui.theme.AppTheme.dimensions

@Composable
fun StartDrawableText(
    modifier: Modifier = Modifier,
    iconSize: Dp = dimensions.iconSizeNormal,
    @DrawableRes iconResId: Int,
    iconTint: Color = Color.White,
    drawablePadding: Dp = dimensions.spacingSmall,
    textColor: Color = Color.White,
    textSize: TextUnit = dimensions.textSizeNormal,
    text: String? = null
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.Top
    ) {
        Icon(
            modifier = Modifier
                .size(iconSize)
                .padding(top = dimensions.spacingSmallest),
            painter = painterResource(id = iconResId),
            contentDescription = null,
            tint = iconTint
        )
        Text(
            modifier = modifier
                .padding(start = drawablePadding),
            color = textColor,
            fontSize = textSize,
            text = text.orEmpty()
        )
    }
}

@Preview
@Composable
fun StartDrawableTextPreview() {
    StartDrawableText(
        iconResId = R.drawable.ic_compass,
        text = "Start drawable text"
    )
}
