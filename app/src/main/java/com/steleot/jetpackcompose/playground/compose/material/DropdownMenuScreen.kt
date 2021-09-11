package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.MaterialNavRoutes

private const val Url = "material/DropdownMenuScreen.kt"

@Composable
fun DropdownMenuScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.DropdownMenu,
        link = Url,
    ) {
        var expanded by remember { mutableStateOf(false) }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
        ) {
            IconButton(onClick = { expanded = true }) {
                Icon(Icons.Filled.MoreVert, contentDescription = "Localized description")
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(onClick = { /* Handle refresh! */ }) {
                    Text("Refresh")
                }
                DropdownMenuItem(onClick = { /* Handle settings! */ }) {
                    Text("Settings")
                }
                Divider()
                DropdownMenuItem(onClick = { /* Handle send feedback! */ }) {
                    Text("Send Feedback")
                }
            }
        }
    }
}
