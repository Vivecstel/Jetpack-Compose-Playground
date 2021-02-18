package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.layout.*
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
import com.steleot.jetpackcompose.playground.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.*

@Composable
fun IconScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.Icon.capitalize(Locale.getDefault())
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
fun DefaultIcon() {
    Icon(
        Icons.Default.AccountBox,
        contentDescription = "Default Icon Button",
    )
}

@Preview
@Composable
fun TintedIcon() {
    Icon(
        Icons.Default.AddAlarm,
        contentDescription = "Tinted Icon",
        modifier = Modifier.preferredSize(48.dp),
        tint = Color.Magenta,
    )
}
