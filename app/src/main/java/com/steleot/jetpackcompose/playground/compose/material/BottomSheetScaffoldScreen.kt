package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.theme.colors
import kotlinx.coroutines.launch

private const val Url = "material/BottomSheetScaffoldScreen.kt"

@Composable
fun BottomSheetScaffoldScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.BottomSheetScaffold,
        link = Url,
    ) {
        BottomSheetScaffoldExample()
    }
}

@Composable
@OptIn(ExperimentalMaterialApi::class)
fun BottomSheetScaffoldExample() {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberBottomSheetScaffoldState()
    BottomSheetScaffold(
        sheetContent = {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(128.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(context.getString(R.string.swipe_up_to_expand))
            }
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(64.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(context.getString(R.string.content))
                Spacer(Modifier.height(20.dp))
                Button(
                    onClick = {
                        scope.launch { scaffoldState.bottomSheetState.collapse() }
                    }
                ) {
                    Text(context.getString(R.string.click_to_collapse))
                }
            }
        },
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = { Text(context.getString(R.string.bottom_sheet_scaffold)) },
                navigationIcon = {
                    IconButton(onClick = { scope.launch { scaffoldState.drawerState.open() } }) {
                        Icon(Icons.Filled.Menu, contentDescription = null)
                    }
                }
            )
        },
        floatingActionButton = {
            var clickCount by remember { mutableStateOf(0) }
            FloatingActionButton(
                onClick = {
                    scope.launch {
                        scaffoldState.snackbarHostState.showSnackbar(
                            context.getString(
                                R.string.snackbar_count,
                                ++clickCount
                            )
                        )
                    }
                }
            ) {
                Icon(Icons.Filled.Favorite, contentDescription = null)
            }
        },
        floatingActionButtonPosition = FabPosition.End,
        sheetPeekHeight = 128.dp,
        drawerContent = {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(context.getString(R.string.app_name))
                Spacer(Modifier.height(20.dp))
                Button(onClick = { scope.launch { scaffoldState.drawerState.close() } }) {
                    Text(context.getString(R.string.click_to_close))
                }
            }
        }
    ) { innerPadding ->
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
}