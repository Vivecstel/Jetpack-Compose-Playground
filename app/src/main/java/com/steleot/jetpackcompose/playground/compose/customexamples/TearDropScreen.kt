package com.steleot.jetpackcompose.playground.compose.customexamples

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.CustomExamplesNavRoutes

private const val Url = "customexamples/TearDropScreen.kt"

@Composable
fun TearDropScreen() {
    DefaultScaffold(
        title = CustomExamplesNavRoutes.TearDrop,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TearDrop("10")
        }
    }
}

private val TearDropShape = RoundedCornerShape(
    topStartPercent = 50,
    topEndPercent = 50,
    bottomEndPercent = 10,
    bottomStartPercent = 50
)

@Composable
fun TearDrop(
    text: String,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = TearDropShape,
        color = MaterialTheme.colors.primary,
        modifier = modifier
            .padding(24.dp)
            .size(60.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 30.sp
            )
        }
    }
}