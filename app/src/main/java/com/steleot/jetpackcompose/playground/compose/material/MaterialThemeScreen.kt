package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "material/IconScreen.kt"

@Composable
fun MaterialThemeScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.MaterialTheme,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MaterialThemeExample()
        }
    }
}

@Composable
private fun MaterialThemeExample() {
    val inSystemDarkTheme = isSystemInDarkTheme()
    val lightColors = lightColors(
        secondary = Color.Red,
        onSecondary = Color.White,
    )

    val darkColors = darkColors(
        secondary = Color.Blue,
        onSecondary = Color.White,
    )

    val colors = if (inSystemDarkTheme) darkColors else lightColors

    val shapes = Shapes(
        small = RoundedCornerShape(8.dp),
    )

    val typography = Typography(
        h1 = TextStyle(
            fontWeight = FontWeight.W100,
            fontSize = 96.sp
        ),
        button = TextStyle(
            fontWeight = FontWeight.W600,
            fontSize = 14.sp
        )
    )

    MaterialTheme(colors = colors, shapes = shapes, typography = typography) {
        val theme = stringResource(id = if (inSystemDarkTheme) R.string.dark else R.string.light)
        ExtendedFloatingActionButton(
            text = { Text(stringResource(id = R.string.material_theme_msg, theme)) },
            onClick = {}
        )
    }
}