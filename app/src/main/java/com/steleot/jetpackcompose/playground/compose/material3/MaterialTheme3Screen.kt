package com.steleot.jetpackcompose.playground.compose.material3

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.*
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
import com.steleot.jetpackcompose.playground.navigation.graph.Material3NavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material3.DefaultScaffold

private const val URL = "material3/MaterialTheme3Screen.kt"

@Composable
fun MaterialTheme3Screen() {
    DefaultScaffold(
        title = Material3NavRoutes.MaterialTheme3,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues = it),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MaterialThemeExample()
        }
    }
}

@Composable
private fun MaterialThemeExample() {
    val inSystemDarkTheme = isSystemInDarkTheme()
    val lightColorScheme = lightColorScheme(
        secondary = Color.Red,
        onSecondary = Color.White,
    )

    val darkColorScheme = darkColorScheme(
        secondary = Color.Blue,
        onSecondary = Color.White,
    )

    val colorScheme = if (inSystemDarkTheme) lightColorScheme else darkColorScheme

    val shapes = Shapes(
        large = CutCornerShape(12.dp)
    )

    val typography = Typography(
        headlineLarge = TextStyle(
            fontWeight = FontWeight.W300,
            fontSize = 40.sp
        ),
        bodyMedium = TextStyle(
            fontWeight = FontWeight.W600,
            fontSize = 16.sp
        )
    )

    MaterialTheme(colorScheme = colorScheme, shapes = shapes, typography = typography) {
        val theme = stringResource(id = if (inSystemDarkTheme) R.string.dark else R.string.light)
        ExtendedFloatingActionButton(
            onClick = {}
        ) {
            Text(stringResource(id = R.string.material_theme_msg, theme))
        }
    }
}