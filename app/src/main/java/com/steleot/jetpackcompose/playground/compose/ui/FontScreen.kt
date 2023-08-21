package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.R as R2
import com.steleot.jetpackcompose.playground.navigation.graph.UiNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "ui/FontScreen.kt"

@Preview
@Composable
fun FontScreen() {
    DefaultScaffold(
        title = UiNavRoutes.Font,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues = it),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(
                    id = R.string.string_with_font,
                    formatArgs = arrayOf("Goblin one")
                ),
                fontFamily = FontFamily(
                    listOf(
                        Font(
                            resId = R2.font.goblin_one_font,
                        )
                    )
                )
            )
            Text(
                text = stringResource(
                    id = R.string.string_with_font,
                    formatArgs = arrayOf("Reggae one")
                ),
                fontFamily = FontFamily(
                    listOf(
                        Font(
                            resId = R2.font.reggae_one_font,
                        )
                    )
                )
            )
        }
    }
}
