package com.steleot.jetpackcompose.playground.compose.material3

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.navigation.Material3NavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material3.DefaultScaffold

private const val Url = "material3/IconToggleButton3Screen.kt"

@Composable
fun IconToggleButton3Screen() {
    DefaultScaffold(
        title = Material3NavRoutes.IconToggleButton3,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DefaultIconToggleButton()
        }
    }
}

@Preview
@Composable
fun DefaultIconToggleButton() {
    var checked by remember { mutableStateOf(false) }
    IconToggleButton(
        checked = checked,
        onCheckedChange = { checked = it },
        modifier = Modifier.size(72.dp),
    ) {
        val tint by animateColorAsState(
            if (checked) Color.Red
            else Color.LightGray
        )
        Icon(
            Icons.Filled.Favorite,
            contentDescription = null,
            tint = tint,
            modifier = Modifier.size(32.dp)
        )
    }
}