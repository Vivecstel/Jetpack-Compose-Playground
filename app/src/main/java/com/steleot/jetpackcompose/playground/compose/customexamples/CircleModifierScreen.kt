package com.steleot.jetpackcompose.playground.compose.customexamples

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.node.DrawModifierNode
import androidx.compose.ui.node.ModifierNodeElement
import androidx.compose.ui.platform.InspectorInfo
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.navigation.graph.CustomExamplesNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "customexamples/CircleModifierScreen.kt"

@Composable
fun CircleModifierScreen() {
    DefaultScaffold(
        title = CustomExamplesNavRoutes.CircleModifier,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues = it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(75.dp)
                    .circle(color = MaterialTheme.colors.primary)
            )
        }
    }
}

fun Modifier.circle(color: Color) = this then CircleElement(color)

data class CircleElement(
    val color: Color
) : ModifierNodeElement<Circle>() {

    override fun create() = Circle(color)

    override fun update(node: Circle) {
        node.color = color
    }

    override fun InspectorInfo.inspectableProperties() {
        name = "circle"
        properties["color"] = color
    }
}

class Circle(var color: Color) : DrawModifierNode, Modifier.Node() {
    override fun ContentDrawScope.draw() {
        drawCircle(color)
    }
}
