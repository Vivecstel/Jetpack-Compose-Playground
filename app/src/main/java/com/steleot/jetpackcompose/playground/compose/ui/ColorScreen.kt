package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.navigation.UiNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val Url = "ui/ColorScreen.kt"

@Preview
@Composable
fun ColorScreen() {
    DefaultScaffold(
        title = UiNavRoutes.Color,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.string_resource),
                modifier = Modifier.padding(16.dp),
                color = colorResource(id = R.color.red_500)
            )
            Text(
                text = stringResource(id = R.string.color_resource),
                modifier = Modifier.padding(16.dp),
                color = colorResource(id = R.color.teal_500)
            )
        }
    }
}
