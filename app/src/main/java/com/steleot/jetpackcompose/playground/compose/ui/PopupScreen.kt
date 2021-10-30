package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.UiNavRoutes

private const val Url = "ui/PopupScreen.kt"

@Composable
fun PopupScreen() {
    DefaultScaffold(
        title = UiNavRoutes.Popup,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box {
                val popupWidth = 200.dp
                val popupHeight = 50.dp
                val cornerSize = 16.dp

                Popup(alignment = Alignment.Center) {
                    Box(
                        Modifier
                            .size(popupWidth, popupHeight)
                            .background(Color.Magenta, RoundedCornerShape(cornerSize))
                    )
                }
            }
        }
    }
}