package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Expand
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.theme.colors
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultTopAppBar
import kotlinx.coroutines.launch

private const val URL = "material/ScaffoldScreen.kt"

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
                link = URL,
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
                            .background(Color(colors[it % colors.size]))
                    )
                }
            }
        }
    )
}