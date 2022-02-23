package com.steleot.jetpackcompose.playground.compose.material3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.localproviders.LocalIsDarkTheme
import com.steleot.jetpackcompose.playground.navigation.graph.Material3NavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material3.DefaultScaffold

private const val Url = "material3/LocalContentColor3Screen.kt"

@Composable
fun LocalContentColor3Screen() {
    DefaultScaffold(
        title = Material3NavRoutes.LocalContentColor3,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                stringResource(
                    id = R.string.local_content_color,
                    stringResource(if (LocalIsDarkTheme.current) R.string.white else R.string.black)
                )
            )

            CompositionLocalProvider(LocalContentColor provides Color.Red) {
                Text(
                    stringResource(
                        id = R.string.local_content_color,
                        stringResource(id = R.string.red)
                    )
                )
            }

            CompositionLocalProvider(LocalContentColor provides Color.Magenta) {
                Text(
                    stringResource(
                        id = R.string.local_content_color,
                        stringResource(id = R.string.magenta)
                    )
                )
            }
        }
    }
}