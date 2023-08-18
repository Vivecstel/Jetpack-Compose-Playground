package com.steleot.jetpackcompose.playground.compose.ui

import android.os.Build
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.UiNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "ui/BlurScreen.kt"

@Composable
fun BlurScreen() {
    DefaultScaffold(
        title = UiNavRoutes.Blur,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            BlurExample()
        }
    }
}

@Composable
private fun BlurExample() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        Box(
            modifier = Modifier
                .size(150.dp)
                .blur(30.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.Center)
                    .background(MaterialTheme.colors.primary)
            )
        }
    } else {
        Text(
            stringResource(id = R.string.android_12_blur),
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.Bold,
        )
    }
}