package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
import kotlinx.coroutines.launch

private const val URL = "material/BackdropScaffoldScreen.kt"

@Composable
fun BackdropScaffoldScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.BackdropScaffold,
        link = URL,
    ) {
        BackdropScaffoldExample()
    }
}

@Composable
@OptIn(ExperimentalMaterialApi::class)
fun BackdropScaffoldExample() {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val selection = remember { mutableIntStateOf(1) }
    val scaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed)
    LaunchedEffect(scaffoldState) {
        scaffoldState.reveal()
    }
    BackdropScaffold(
        scaffoldState = scaffoldState,
        appBar = {
            TopAppBar(
                title = { Text(context.getString(R.string.backdrop_scaffold)) },
                navigationIcon = {
                    if (scaffoldState.isConcealed) {
                        IconButton(onClick = { scope.launch { scaffoldState.reveal() } }) {
                            Icon(
                                Icons.Filled.Menu,
                                contentDescription = context.getString(R.string.menu)
                            )
                        }
                    } else {
                        IconButton(onClick = { scope.launch { scaffoldState.conceal() } }) {
                            Icon(
                                Icons.Filled.Close,
                                contentDescription = context.getString(R.string.close)
                            )
                        }
                    }
                },
                actions = {
                    var clickCount by remember { mutableIntStateOf(0) }
                    IconButton(
                        onClick = {
                            scope.launch {
                                scaffoldState.snackbarHostState
                                    .showSnackbar(
                                        context.getString(
                                            R.string.snackbar_count,
                                            ++clickCount
                                        )
                                    )
                            }
                        }
                    ) {
                        Icon(
                            Icons.Filled.Favorite,
                            contentDescription = context.getString(R.string.favorite)
                        )
                    }
                },
                elevation = 0.dp,
                backgroundColor = Color.Transparent
            )
        },
        backLayerContent = {
            LazyColumn {
                items(if (selection.intValue >= 3) 3 else 5) {
                    ListItem(
                        Modifier.clickable {
                            selection.intValue = it
                            scope.launch { scaffoldState.conceal() }
                        },
                        text = { Text(context.getString(R.string.select_args, it)) }
                    )
                }
            }
        },
        frontLayerContent = {
            LazyColumn {
                item {
                    Text(
                        context.getString(R.string.selection_args, selection.intValue),
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                    )
                }
                items(50) {
                    ListItem(
                        text = { Text(context.getString(R.string.item, it)) },
                        icon = {
                            Icon(
                                Icons.Filled.Favorite,
                                contentDescription = context.getString(R.string.favorite)
                            )
                        }
                    )
                }
            }
        }
    )
}