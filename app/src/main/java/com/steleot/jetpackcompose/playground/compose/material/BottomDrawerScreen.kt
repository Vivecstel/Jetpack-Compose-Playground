package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.navigation.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
import kotlinx.coroutines.launch

private const val Url = "material/BottomDrawerScreen.kt"

@Composable
fun BottomDrawerScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.BottomDrawer,
        link = Url,
    ) {
        BottomDrawerExample()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun BottomDrawerExample() {
    val scope = rememberCoroutineScope()
    val drawerState = rememberBottomDrawerState(initialValue = BottomDrawerValue.Closed)
    BottomDrawer(
        drawerContent = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                Button(
                    onClick = { scope.launch { drawerState.close() } },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Red
                    )
                ) {
                    Text(stringResource(id = R.string.click_to_close))
                }
                Button(
                    onClick = { scope.launch { drawerState.expand() } },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Green
                    )
                ) {
                    Text(stringResource(id = R.string.click_to_expand))
                }
            }
        },
        drawerState = drawerState,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Button(onClick = { scope.launch { drawerState.open() } }) {
                Text(stringResource(id = R.string.click_to_open))
            }
        }
    }
}