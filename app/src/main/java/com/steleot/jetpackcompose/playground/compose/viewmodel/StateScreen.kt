package com.steleot.jetpackcompose.playground.compose.viewmodel

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.steleot.jetpackcompose.playground.navigation.graph.ViewModelNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "viewmodel/StateScreen.kt"

@Composable
fun StateScreen() {
    DefaultScaffold(
        title = ViewModelNavRoutes.State,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LiveDataExample()
        }
    }
}

class StateViewModel : ViewModel() {
    var name: String by mutableStateOf("")
        private set

    fun onNameChange(newName: String) {
        name = newName
    }
}

@Composable
private fun LiveDataExample(viewModel: StateViewModel = viewModel()) {
    val name = viewModel.name
    HelloContent(name) { viewModel.onNameChange(it) }
}
