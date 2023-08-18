package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AddAlarm
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.navigation.graph.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "material/IconScreen.kt"

@Composable
fun IconScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.Icon,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DefaultIcon()
            TintedIcon()
        }
    }
}

@Preview
@Composable
private fun DefaultIcon() {
    Icon(
        Icons.Filled.AccountBox,
        contentDescription = null,
    )
}

@Preview
@Composable
private fun TintedIcon() {
    Icon(
        Icons.Filled.AddAlarm,
        contentDescription = null,
        modifier = Modifier.size(48.dp),
        tint = Color.Magenta,
    )
}
