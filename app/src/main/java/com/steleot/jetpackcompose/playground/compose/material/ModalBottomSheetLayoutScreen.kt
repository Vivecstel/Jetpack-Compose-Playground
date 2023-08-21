package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
import kotlinx.coroutines.launch

private const val URL = "material/ModalBottomSheetLayoutScreen.kt"

@Composable
fun ModalBottomSheetLayoutScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.ModalBottomSheetLayout,
        link = URL,
    ) {
        ModalBottomSheetLayoutExample(paddingValues = it)
    }
}

@Composable
@OptIn(ExperimentalMaterialApi::class)
private fun ModalBottomSheetLayoutExample(paddingValues: PaddingValues) {
    val state = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
    val scope = rememberCoroutineScope()
    ModalBottomSheetLayout(
        sheetState = state,
        sheetContent = {
            LazyColumn {
                items(50) {
                    ListItem(
                        text = {
                            Text(stringResource(id = R.string.item, it))
                        },
                        icon = {
                            Icon(
                                Icons.Filled.Favorite,
                                contentDescription = stringResource(id = R.string.favorite)
                            )
                        }
                    )
                }
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(stringResource(id = R.string.content))
            Spacer(Modifier.height(20.dp))
            Button(onClick = { scope.launch { state.show() } }) {
                Text(stringResource(id = R.string.click_show_sheet))
            }
        }
    }
}