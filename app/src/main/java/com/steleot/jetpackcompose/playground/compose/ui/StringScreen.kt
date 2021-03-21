package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.UiNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.Locale

private const val Url = "ui/StringScreen.kt"

@Preview
@Composable
fun StringScreen() {
    DefaultScaffold(
        title = UiNavRoutes.String.capitalize(Locale.getDefault()),
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.string_resource),
                modifier = Modifier.padding(16.dp)
            )
            Text(
                text = stringResource(
                    id = R.string.string_with_format,
                    formatArgs = arrayOf(stringResource(id = R.string.jetpack_compose_playground))
                ),
                modifier = Modifier.padding(16.dp)
            )
            stringArrayResource(id = R.array.string_array).forEach {
                Text(
                    text = it,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}
