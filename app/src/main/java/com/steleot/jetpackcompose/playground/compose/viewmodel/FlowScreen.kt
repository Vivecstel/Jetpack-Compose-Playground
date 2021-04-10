package com.steleot.jetpackcompose.playground.compose.viewmodel

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.steleot.jetpackcompose.playground.ViewModelNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

private const val Url = "viewmodel/FlowLayoutScreen.kt"

@Composable
fun ViewModelFlowScreen() {
    DefaultScaffold(
        title = ViewModelNavRoutes.Flow,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            FlowExample()
        }
    }
}

class FlowViewModel : ViewModel() {
    private val _name = MutableStateFlow("")
    val name: StateFlow<String> = _name

    fun onNameChange(newName: String) {
        _name.value = newName
    }
}

@Composable
private fun FlowExample(viewModel: FlowViewModel = viewModel()) {
    val name: String by viewModel.name.collectAsState()
    HelloContent(name) { viewModel.onNameChange(it) }
}

@Composable
internal fun HelloContent(name: String, onNameChange: (String) -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Hello, $name",
            modifier = Modifier.padding(bottom = 8.dp),
            style = MaterialTheme.typography.h5
        )
        OutlinedTextField(
            value = name,
            onValueChange = { onNameChange(it) },
            label = { Text("Name") }
        )
    }
}
