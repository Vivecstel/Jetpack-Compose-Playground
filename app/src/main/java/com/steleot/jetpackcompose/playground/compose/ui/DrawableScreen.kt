package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.UiNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.*

@Preview
@Composable
fun DrawableScreen() {
    DefaultScaffold(
        title = UiNavRoutes.Drawable.capitalize(Locale.getDefault())
    ) {
        val colors = MaterialTheme.colors
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(
                    id =
                    R.drawable.ic_android_black_24dp
                ),
                contentDescription = "Vector image from painter resource",
                modifier = Modifier.size(32.dp),
                colorFilter = ColorFilter.tint(colors.primary)
            )
            Image(
                painter = painterResource(
                    id =
                    R.drawable.ic_baseline_alarm_24dp
                ),
                contentDescription = "Drawable image from painter resource",
                modifier = Modifier.size(48.dp),
                colorFilter = ColorFilter.tint(colors.primaryVariant)
            )
        }
    }
}
