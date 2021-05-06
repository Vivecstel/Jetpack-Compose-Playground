package com.steleot.jetpackcompose.playground.compose.foundationlayout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.FoundationLayoutNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold

private const val Url = "foundationlayout/IntrinsicScreen.kt"

@Composable
fun IntrinsicScreen() {
    DefaultScaffold(
        title = FoundationLayoutNavRoutes.Intrinsic,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .requiredHeight(IntrinsicSize.Max)
                    .requiredWidth(IntrinsicSize.Max)
                    .padding(16.dp)
                    .background(Color.Green)
            ) {
                Text(text = "Intrinsic Size Max")
                Text(text = "Taking the max size here..")
            }
            Column(
                modifier = Modifier
                    .requiredHeight(IntrinsicSize.Min)
                    .requiredWidth(IntrinsicSize.Min)
                    .padding(16.dp)
                    .background(Color.Green)
            ) {
                Text(text = "Intrinsic Size Min")
                Text(text = "Taking the min size here..")
            }
        }
    }
}