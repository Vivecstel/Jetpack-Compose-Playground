package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.LocalContentColor
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.localproviders.LocalIsDarkTheme
import com.steleot.jetpackcompose.playground.navigation.graph.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "material/LocalContentColorScreen.kt"

@Composable
fun LocalContentColorScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.LocalContentColor,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues = it),
            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
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