package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.UiNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.Locale

private const val Url = "ui/FontScreen.kt"

@Preview
@Composable
fun FontScreen() {
    DefaultScaffold(
        title = UiNavRoutes.Font.capitalize(Locale.getDefault()),
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
                    formatArgs = arrayOf("Ballet")
                ),
                fontFamily = fontResource(
                    fontFamily = FontFamily(
                        listOf(
                            Font(
                                resId = R.font.ballet_font,
                            )
                        )
                    )
                ).fontFamily
            )
            Text(
                text = stringResource(
                    id = R.string.string_with_font,
                    formatArgs = arrayOf("Reggae one")
                ),
                fontFamily = fontResource(
                    fontFamily = FontFamily(
                        listOf(
                            Font(
                                resId = R.font.reggae_one_font,
                            )
                        )
                    )
                ).fontFamily
            )
        }
    }
}
