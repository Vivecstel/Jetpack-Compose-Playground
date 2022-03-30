package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.loukwn.stagestepbar_compose.StageStepBar
import com.loukwn.stagestepbar_compose.data.DrawnComponent
import com.loukwn.stagestepbar_compose.data.StageStepBarConfig
import com.loukwn.stagestepbar_compose.data.State
import com.steleot.jetpackcompose.playground.navigation.graph.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val Url = "externallibraries/StageStepBarScreen.kt"

@Composable
fun StageStepBarScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.StageStepBar,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            StageStepBarExample()
        }
    }
}

@Composable
private fun StageStepBarExample() {
    StageStepBar(
        modifier = Modifier
            .height(100.dp)
            .width(300.dp),
        config = StageStepBarConfig.default()
            .copy(
                stageStepConfig = listOf(5, 5, 5),
                filledTrack = DrawnComponent.Default(
                    color = MaterialTheme.colors.primary
                ),
                unfilledTrack = DrawnComponent.Default(
                    color = Color.Gray
                ),
                filledThumb = DrawnComponent.Default(
                    color = MaterialTheme.colors.primary
                ),
                unfilledThumb = DrawnComponent.Default(
                    color = Color.Gray
                ),
                currentState = State(2, 3)
            ),
    )
}