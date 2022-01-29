package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Expand
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.systemBarsPadding
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultTopAppBar
import com.steleot.jetpackcompose.playground.navigation.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.theme.colors
import kotlinx.coroutines.launch

private const val Url = "material/ScaffoldScreen.kt"

@Composable
fun ScaffoldScreen() {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val text = stringResource(id = R.string.app_name)
    Scaffold(
        modifier = Modifier.systemBarsPadding(),
        scaffoldState = scaffoldState,
        drawerContent = { Text(stringResource(id = R.string.content)) },
        topBar = {
            DefaultTopAppBar(
                title = MaterialNavRoutes.Scaffold,
                link = Url,
            )
        },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text(stringResource(id = R.string.show_snackbar)) },
                icon = {
                    Icon(
                        imageVector = Icons.Filled.Expand,
                        contentDescription = null
                    )
                },
                onClick = {
                    scope.launch {
                        scaffoldState.snackbarHostState.showSnackbar(text)
                    }
                }
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