package com.steleot.jetpackcompose.playground.compose.runtime

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.RuntimeNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
import kotlinx.coroutines.launch
import timber.log.Timber

private const val URL = "runtime/SideEffectScreen.kt"

private val touchHandler = TouchHandler(false)

@Composable
fun SideEffectScreen() {
    DefaultScaffold(
        title = RuntimeNavRoutes.SideEffect,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues = it),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SideEffectExample(touchHandler)
        }
    }
}

@Suppress("SameParameterValue")
@Composable
private fun SideEffectExample(touchHandler: TouchHandler) {
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    SideEffect {
        touchHandler.enabled = drawerState.isOpen
        Timber.d("Touch handler enabled value is : ${touchHandler.enabled}")
    }
    ModalDrawer(
        drawerContent = {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Button(
                    onClick = { scope.launch { drawerState.close() } },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.secondary
                    )
                ) {
                    Text(stringResource(id = R.string.click_to_close))
                }
            }
        },
        drawerState = drawerState
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

private class TouchHandler(
    var enabled: Boolean
)