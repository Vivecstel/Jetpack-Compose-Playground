package com.steleot.jetpackcompose.playground.compose.material3

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.Material3NavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material3.DefaultScaffold
import timber.log.Timber

private const val URL = "material3/DropdownMenu3Screen.kt"

@Composable
fun DropdownMenu3Screen() {
    DefaultScaffold(
        title = Material3NavRoutes.DropdownMenu3,
        link = URL,
    ) {
        var expanded by remember { mutableStateOf(false) }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = it)
                .wrapContentSize(Alignment.Center)
        ) {
            IconButton(onClick = { expanded = true }) {
                Icon(Icons.Filled.MoreVert, contentDescription = null)
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(
                    text = {
                        Text(stringResource(id = R.string.refresh))
                    },
                    onClick = {
                        Timber.d("Refresh clicked")
                    })
                DropdownMenuItem(
                    text = {
                        Text(stringResource(id = R.string.settings))
                    },
                    onClick = {
                        Timber.d("Settings clicked")
                    })
                HorizontalDivider()
                DropdownMenuItem(
                    text = {
                        Text(stringResource(id = R.string.send_feedback))
                    },
                    onClick = {
                        Timber.d("Send Feedback")
                    })
            }
        }
    }
}