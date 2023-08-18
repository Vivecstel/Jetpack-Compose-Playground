package com.steleot.jetpackcompose.playground.compose.ui

import android.graphics.Typeface
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFontFamilyResolver
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.R as R2
import com.steleot.jetpackcompose.playground.navigation.graph.UiNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "ui/LocalFontFamilyResolverScreen.kt"

@Composable
fun LocalFontFamilyResolverScreen() {
    DefaultScaffold(
        title = UiNavRoutes.LocalFontFamilyResolver,
        link = URL,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LocalFontFamilyResolverExample()
        }
    }
}

@Composable
private fun LocalFontFamilyResolverExample() {
    val resolver = LocalFontFamilyResolver.current
    val typeface = resolver.resolve(FontFamily(Font(R2.font.reggae_one_font))).value as Typeface
    Text(
        text = stringResource(id = R.string.local_font_family_resolver),
        fontFamily = FontFamily(typeface)
    )
}