package com.steleot.jetpackcompose.playground.compose.material3

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Expand
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.systemBarsPadding
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultSmallTopAppBar
import com.steleot.jetpackcompose.playground.localproviders.LocalThemeState
import com.steleot.jetpackcompose.playground.navigation.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.theme.JetpackComposePlaygroundTheme3
import com.steleot.jetpackcompose.playground.theme.colors

private const val Url = "material3/Scaffold3Screen.kt"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Scaffold3Screen() {
    val themeState = LocalThemeState.current
    JetpackComposePlaygroundTheme3(
        themeState = themeState
    ) {
        val scaffoldState = rememberScaffoldState()
        Scaffold(
            modifier = Modifier.systemBarsPadding(),
            scaffoldState = scaffoldState,
            drawerContent = { Text(stringResource(id = R.string.content)) },
            topBar = {
                DefaultSmallTopAppBar(
                    title = MaterialNavRoutes.Scaffold,
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
                                .background(colors[it % colors.size])
                        )
                    }
                }
            }
        )
    }
}