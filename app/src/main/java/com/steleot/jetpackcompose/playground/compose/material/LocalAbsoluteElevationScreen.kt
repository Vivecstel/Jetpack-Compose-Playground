package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.LocalAbsoluteElevation
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.MaterialNavRoutes

private const val Url = "material/LocalAbsoluteElevationScreen.kt"

@Composable
fun LocalAbsoluteElevationScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.LocalAbsoluteElevation,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface(
                modifier = Modifier
                    .size(200.dp)
                    .background(Color.Blue),
                elevation = 4.dp
            ) {
                Surface(
                    modifier = Modifier,
                    elevation = 2.dp
                ) {
                    Surface(
                        modifier = Modifier,
                        elevation = 4.dp
                    ) {
                        val elevation = LocalAbsoluteElevation.current
                        Text(
                            text = "Local Absolute Elevation: $elevation",
                        )
                    }
                }
            }
        }
    }
}