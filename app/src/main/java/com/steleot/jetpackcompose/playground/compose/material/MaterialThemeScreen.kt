package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.MaterialNavRoutes

private const val Url = "material/Icon3Screen.kt"

@Composable
fun MaterialThemeScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.MaterialTheme,
        link = Url,
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
fun MaterialThemeExample() {
    val lightColors = lightColors(
        secondary = Color.Red,
        onSecondary = Color.White,
    )

    val darkColors = darkColors(
        secondary = Color.Blue,
        onSecondary = Color.White,
    )

    val colors = if (isSystemInDarkTheme()) darkColors else lightColors

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

    MaterialTheme(colors = colors, typography = typography) {
        val currentTheme = if (MaterialTheme.colors.isLight) "light" else "dark"
        ExtendedFloatingActionButton(
            text = { Text("FAB with text style and color from $currentTheme theme") },
            onClick = {}
        )
    }
}