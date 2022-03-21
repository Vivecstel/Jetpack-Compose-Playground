package com.steleot.jetpackcompose.playground.compose.material3

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Expand
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.localproviders.LocalThemeState
import com.steleot.jetpackcompose.playground.navigation.graph.Material3NavRoutes
import com.steleot.jetpackcompose.playground.theme.colors
import com.steleot.jetpackcompose.playground.ui.base.material3.DefaultSmallTopAppBar
import com.steleot.jetpackcompose.playground.theme.material3.JetpackComposePlaygroundTheme as Theme3

private const val Url = "material3/Scaffold3Screen.kt"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Scaffold3Screen() {
    val themeState = LocalThemeState.current
    Theme3(
        themeState = themeState
    ) {
        Scaffold(
            modifier = Modifier.systemBarsPadding(),
            topBar = {
                DefaultSmallTopAppBar(
                    title = Material3NavRoutes.Scaffold3,
                    link = Url,
                )
            },
            floatingActionButtonPosition = FabPosition.End,
            floatingActionButton = {
                ExtendedFloatingActionButton(
                    text = { Text(stringResource(id = R.string.click_me)) },
                    icon = {
                        Icon(
                            imageVector = Icons.Filled.Expand,
                            contentDescription = null
                        )
                    },
                    onClick = { }
                )
            },
            content = { innerPadding ->
                LazyColumn(contentPadding = innerPadding) {
                    items(100) {
                        Box(
                            Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                                .background(Color(colors[it % colors.size]))
                        )
                    }
                }
            }
        )
    }
}