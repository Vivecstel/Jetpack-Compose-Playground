package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.FoundationNavRoutes

private const val Url = "foundation/ShapeScreen.kt"

@Composable
fun ShapeScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.Shape,
        link = Url,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircleShapeBox()
            RectangleShapeBox()
            CutCornerShapeComponent()
            AlternateCutCornerShapeBox()
            FloatCutCornerShapeBox()
            PercentCutCornerShapeBox()
            RoundedCornerShapeBox()
            AlternateRoundedCornerShapeBox()
            GenericShapeBox()
        }
    }
}

@Preview
@Composable
private fun CircleShapeBox() {
    Box(
        modifier = Modifier.background(Color.Magenta, shape = CircleShape)
    ) {
        Text(
            text = "Circle shape",
            modifier = Modifier.padding(16.dp),
            color = Color.White
        )
    }
}

@Preview
@Composable
fun RectangleShapeBox() {
    Box(
        modifier = Modifier.background(Color.Blue, shape = RectangleShape)
    ) {
        Text(
            text = "Rectangle shape",
            modifier = Modifier.padding(16.dp),
            color = Color.White
        )
    }
}

@Preview
@Composable
private fun CutCornerShapeComponent() {
    Box(
        modifier = Modifier.background(Color.Red, shape = CutCornerShape(15.dp))
    ) {
        Text(
            text = "Cut corner shape",
            modifier = Modifier.padding(16.dp),
            color = Color.White
        )
    }
}

@Preview
@Composable
private fun AlternateCutCornerShapeBox() {
    Box(
        modifier = Modifier.background(
            Color.Yellow,
            shape = CutCornerShape(15.dp, 6.dp, 15.dp, 12.dp)
        )
    ) {
        Text(
            text = "Cut corner shape",
            modifier = Modifier.padding(16.dp),
            color = Color.White
        )
    }
}

@Preview
@Composable
private fun FloatCutCornerShapeBox() {
    Box(
        modifier = Modifier.background(Color.Cyan, shape = CutCornerShape(15f, 6f, 15f, 12f))
    ) {
        Text(
            text = "Cut corner shape",
            modifier = Modifier.padding(16.dp),
            color = Color.White
        )
    }
}

@Preview
@Composable
private fun PercentCutCornerShapeBox() {
    Box(
        modifier = Modifier.background(Color.DarkGray, shape = CutCornerShape(40, 20, 50, 10))
    ) {
        Text(
            text = "Cut corner shape",
            modifier = Modifier.padding(16.dp),
            color = Color.White
        )
    }
}

@Preview
@Composable
private fun RoundedCornerShapeBox() {
    Box(
        modifier = Modifier.background(Color.LightGray, shape = RoundedCornerShape(10.dp))
    ) {
        Text(
            text = "Rounded corner shape",
            modifier = Modifier.padding(16.dp),
            color = Color.White
        )
    }
}

@Preview
@Composable
private fun AlternateRoundedCornerShapeBox() {
    Box(
        modifier = Modifier.background(
            Color.Blue,
            shape = RoundedCornerShape(12.dp, 0.dp, 12.dp, 0.dp)
        )
    ) {
        Text(
            text = "Rounded corner shape",
            modifier = Modifier.padding(16.dp),
            color = Color.White
        )
    }
}

@Preview
@Composable
private fun GenericShapeBox() {
    Box(
        modifier = Modifier.background(Color.Green, shape = GenericShape(builder = { _, _ ->
            this.addOval(
                Rect(
                    top = 0f,
                    bottom = 175f,
                    left = -50f,
                    right = 320f
                )
            )
        }))
    ) {
        Text(
            text = "Generic shape",
            modifier = Modifier.padding(16.dp),
            color = Color.White
        )
    }
}