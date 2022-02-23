package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.navigation.UiNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val Url = "ui/FontScreen.kt"

@Preview
@Composable
fun FontScreen() {
    DefaultScaffold(
        title = UiNavRoutes.Font,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
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
                            resId = R.font.goblin_one_font,
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
                            resId = R.font.reggae_one_font,
                        )
                    )
                )
            )
        }
    }
}
