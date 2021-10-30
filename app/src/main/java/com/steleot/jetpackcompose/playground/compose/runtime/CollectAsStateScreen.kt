package com.steleot.jetpackcompose.playground.compose.runtime

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.RuntimeNavRoutes
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow

private const val Url = "runtime/CollectAsStateScreen.kt"

@Composable
fun CollectAsStateScreen() {
    DefaultScaffold(
        title = RuntimeNavRoutes.CollectAsState,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CollectAsStateFlowExample(
                flow {
                    emit("Jetpack compose")
                }
            )
            CollectAsStateStateFlowExample(
                MutableStateFlow("Compose").asStateFlow()
            )
        }
    }
}

@Composable
private fun CollectAsStateFlowExample(flow: Flow<String>) {
    val value: String by flow.collectAsState("initial")
    Text("Value is $value")
}

@Composable
private fun CollectAsStateStateFlowExample(stateFlow: StateFlow<String>) {
    val value: String by stateFlow.collectAsState()
    Text("Value is $value")
}