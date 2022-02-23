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
import androidx.compose.ui.res.stringResource
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.navigation.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
import timber.log.Timber

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
                Icon(Icons.Filled.MoreVert, contentDescription = null)
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(onClick = {
                    Timber.d("Refresh clicked")
                }) {
                    Text(stringResource(id = R.string.refresh))
                }
                DropdownMenuItem(onClick = {
                    Timber.d("Settings clicked")
                }) {
                    Text(stringResource(id = R.string.settings))
                }
                Divider()
                DropdownMenuItem(onClick = {
                    Timber.d("Send Feedback")
                }) {
                    Text(stringResource(id = R.string.send_feedback))
                }
            }
        }
    }
}
