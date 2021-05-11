package com.steleot.jetpackcompose.playground.compose.ui

import android.graphics.Typeface
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFontLoader
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.UiNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold

private const val Url = "ui/LocalFontLoaderScreen.kt"

@Composable
fun LocalFontLoaderScreen() {
    DefaultScaffold(
        title = UiNavRoutes.LocalFontLoader,
        link = Url,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LocalFontLoaderExample()
        }
    }
}

@Composable
private fun LocalFontLoaderExample() {
    val fontLoader = LocalFontLoader.current
    val typeface = fontLoader.load(Font(R.font.reggae_one_font)) as Typeface
    Text(
        text = "Local Font Loader with reggae one font",
        fontFamily = FontFamily(typeface)
    )
}