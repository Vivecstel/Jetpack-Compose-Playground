package com.steleot.jetpackcompose.playground.compose.foundationlayout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.FoundationLayoutNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.Locale

private const val Url = "foundationlayout/IntrinsicScreen.kt"

@Composable
fun IntrinsicScreen() {
    DefaultScaffold(
        title = FoundationLayoutNavRoutes.Intrinsic.capitalize(Locale.getDefault()),
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