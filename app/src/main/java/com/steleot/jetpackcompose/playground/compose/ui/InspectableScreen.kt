package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.platform.inspectable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.UiNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "ui/InspectableScreen.kt"

@Composable
fun InspectableScreen() {
    DefaultScaffold(
        title = UiNavRoutes.Inspectable,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues = it),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            InspectableExample()
        }
    }
}

@Composable
private fun InspectableExample() {
    Text(
        text = stringResource(id = R.string.app_name),
        modifier = Modifier
            .debugFrame(Color.Red)
    )
}

private fun Modifier.debugFrame(color: Color) = inspectable(
    inspectorInfo = debugInspectorInfo {
        name = "debugFrame"
        value = color
    }
) {
    background(color, RoundedCornerShape(5.0.dp))
}