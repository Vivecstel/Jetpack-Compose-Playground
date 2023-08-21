package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.LocalTextStyle
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.FoundationNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
import timber.log.Timber

private const val URL = "foundation/InteractionSourceScreen.kt"

@Composable
fun InteractionSourceScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.InteractionSource,
        link = URL,
    ) {
        SimpleInteractionSourceExample(paddingValues = it)
    }
}

@Composable
private fun SimpleInteractionSourceExample(paddingValues: PaddingValues) {
    val interactionSource = remember { MutableInteractionSource() }

    val draggable = Modifier.draggable(
        interactionSource = interactionSource,
        orientation = Orientation.Horizontal,
        state = rememberDraggableState { /* update some business state here */ }
    )

    val clickable = Modifier.clickable(
        interactionSource = interactionSource,
        indication = LocalIndication.current
    ) {
        Timber.d("Clicked...")
    }

    val isDragged by interactionSource.collectIsDraggedAsState()
    val isPressed by interactionSource.collectIsPressedAsState()

    val (text, color) = when {
        isDragged && isPressed -> stringResource(id = R.string.dragged_pressed) to Color.Red
        isDragged -> stringResource(id = R.string.dragged) to Color.Green
        isPressed -> stringResource(id = R.string.pressed) to Color.Blue
        else -> stringResource(id = R.string.interaction_source_message) to MaterialTheme.colors.primary
    }

    Box(
        Modifier
            .fillMaxSize()
            .padding(paddingValues = paddingValues)
            .wrapContentSize()
            .size(width = 240.dp, height = 80.dp)
    ) {
        Box(
            Modifier
                .fillMaxSize()
                .then(clickable)
                .then(draggable)
                .border(BorderStroke(3.dp, color))
                .padding(3.dp)
        ) {
            Text(
                text, style = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize()
            )
        }
    }
}