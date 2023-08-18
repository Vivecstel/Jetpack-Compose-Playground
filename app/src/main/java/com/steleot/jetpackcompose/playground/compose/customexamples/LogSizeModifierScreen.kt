package com.steleot.jetpackcompose.playground.compose.customexamples

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateValue
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.node.LayoutAwareModifierNode
import androidx.compose.ui.node.ModifierNodeElement
import androidx.compose.ui.platform.InspectorInfo
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.navigation.graph.CustomExamplesNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
import timber.log.Timber

private const val URL = "customexamples/LogSizeModifierScreen.kt"

@Composable
fun LogSizeModifierScreen() {
    DefaultScaffold(
        title = CustomExamplesNavRoutes.LogSizeModifier,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LogSizeModifierExample()
        }
    }
}

@Composable
private fun LogSizeModifierExample() {
    val infiniteTransition = rememberInfiniteTransition(
        label = "LogSizeModifierExampleInfiniteTransition"
    )
    val sizeDp by infiniteTransition.animateValue(
        initialValue = 50.dp,
        targetValue = 150.dp,
        typeConverter = Dp.VectorConverter,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1_000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "LogSizeModifierExampleSizeDp"
    )
    Box(
        modifier = Modifier
            .size(sizeDp)
            .background(
                color = MaterialTheme.colors.primary,
                shape = RoundedCornerShape(size = 4.dp)
            )
            .logSize(id = "LogSizeModifierExample")
    )
}

fun Modifier.logSize(id: String) = this then LogSizeElement(id)

class SizeLoggerNode(var id: String) : LayoutAwareModifierNode, Modifier.Node() {
    override fun onRemeasured(size: IntSize) {
        Timber.d("The size of $id was $size")
    }
}

data class LogSizeElement(val id: String) : ModifierNodeElement<SizeLoggerNode>() {

    override fun create(): SizeLoggerNode = SizeLoggerNode(id)

    override fun update(node: SizeLoggerNode) {
        node.id = id
    }

    override fun InspectorInfo.inspectableProperties() {
        name = "logSize"
        properties["id"] = id
    }
}

