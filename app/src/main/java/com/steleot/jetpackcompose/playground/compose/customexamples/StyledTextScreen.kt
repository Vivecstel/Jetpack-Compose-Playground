package com.steleot.jetpackcompose.playground.compose.customexamples

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextGeometricTransform
import androidx.compose.ui.unit.sp
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.navigation.CustomExamplesNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val Url = "customexamples/StyledTextScreen.kt"

@Composable
fun StyledTextScreen() {
    DefaultScaffold(
        title = CustomExamplesNavRoutes.StyledText,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            StyledTextExample()
        }
    }
}

@Composable
private fun StyledTextExample() {
    Text(
        text = stringResource(id = R.string.app_name),
        style = TextStyle(
            color = MaterialTheme.colors.primary,
            fontSize = 24.sp,
            fontFamily = FontFamily.Monospace,
            letterSpacing = 4.sp,
            textAlign = TextAlign.Center,
            shadow = Shadow(
                color = if (isSystemInDarkTheme()) Color.White else Color.Black,
                offset = Offset(4f, 4f),
                blurRadius = 3f
            ),
            textGeometricTransform = TextGeometricTransform(
                scaleX = 1.5f,
                skewX = 1f
            )
        ),
    )
}