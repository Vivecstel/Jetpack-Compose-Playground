package com.steleot.jetpackcompose.playground.compose.runtime

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.RuntimeNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
import kotlinx.coroutines.flow.*

private const val URL = "runtime/CollectAsStateScreen.kt"

@Composable
fun CollectAsStateScreen() {
    DefaultScaffold(
        title = RuntimeNavRoutes.CollectAsState,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val text = stringResource(id = R.string.app_name)
            CollectAsStateFlowExample(
                flow {
                    emit(text)
                }
            )
            CollectAsStateStateFlowExample(
                MutableStateFlow(text).asStateFlow()
            )
        }
    }
}

@Composable
private fun CollectAsStateFlowExample(flow: Flow<String>) {
    val value: String by flow.collectAsState("")
    Text(value)
}

@Composable
private fun CollectAsStateStateFlowExample(stateFlow: StateFlow<String>) {
    val value: String by stateFlow.collectAsState()
    Text(value)
}