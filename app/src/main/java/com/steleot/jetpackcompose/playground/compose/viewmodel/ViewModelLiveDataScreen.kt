package com.steleot.jetpackcompose.playground.compose.viewmodel

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.steleot.jetpackcompose.playground.navigation.graph.ViewModelNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "viewmodel/ViewModelLiveDataScreen.kt"

@Composable
fun ViewModelLiveDataScreen() {
    DefaultScaffold(
        title = ViewModelNavRoutes.LiveData,
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

class LiveDataViewModel : ViewModel() {
    private val _name = MutableLiveData("")
    val name: LiveData<String> = _name

    fun onNameChange(newName: String) {
        _name.value = newName
    }
}

@Composable
private fun LiveDataExample(viewModel: LiveDataViewModel = viewModel()) {
    val name by viewModel.name.observeAsState("")
    HelloContent(name) { viewModel.onNameChange(it) }
}

