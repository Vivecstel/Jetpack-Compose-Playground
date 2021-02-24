package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.FoundationNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold

import java.util.*

@Composable
fun BackgroundScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.Background.capitalize(Locale.getDefault())
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(modifier = Modifier.size(50.dp).background(Color.Green))
            Box(
                modifier = Modifier.size(50.dp)
                    .background(Color.Red, shape = RoundedCornerShape(12.dp))
            )
            Box(
                modifier = Modifier.size(50.dp)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(Color.Red, Color.Blue, Color.Green),
                            startX = 0.0f,
                            endX = 500.0f
                        ), shape = CutCornerShape(8.dp)
                    )
            )
        }
    }
}