package com.steleot.jetpackcompose.playground.compose.runtime

import androidx.compose.foundation.layout.*
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.CircularProgressIndicator
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.RuntimeNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import timber.log.Timber

private const val URL = "runtime/ProduceStateScreen.kt"

private val viewModel = ProduceStateViewModel()

@Composable
fun ProduceStateScreen() {
    DefaultScaffold(
        title = RuntimeNavRoutes.ProduceState,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ProduceStateExample(viewModel)
            Spacer(modifier = Modifier.height(16.dp))
            ProduceStateAwaitDisposeExample(viewModel)
        }
    }
}

class ProduceStateViewModel {
    val people: Flow<List<Person>> = flow {
        delay(2_000L)
        emit(
            listOf(
                Person("Jetpack"),
                Person("Compose"),
                Person("Playground"),
            )
        )
    }

    interface Disposable {
        fun dispose()
    }

    fun registerPersonObserver(observer: (Person) -> Unit): Disposable {
        observer(Person("Jetpack Compose Playground"))
        return object : Disposable {
            override fun dispose() {
                Timber.d("Disposed")
            }
        }
    }
}

private sealed class UiState<out T> {
    data object Loading : UiState<Nothing>()
    class Data<T>(val data: T) : UiState<T>()
}

@Suppress("SameParameterValue")
@Composable
private fun ProduceStateExample(viewModel: ProduceStateViewModel) {
    val uiState by produceState<UiState<List<Person>>>(UiState.Loading, viewModel) {
        viewModel.people
            .map { UiState.Data(it) }
            .collect { value = it }
    }

    when (val state = uiState) {
        is UiState.Loading -> CircularProgressIndicator()
        is UiState.Data -> Column {
            for (person in state.data) {
                Text(
                    stringResource(id = R.string.hello_with_args, person.name),
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}

@Suppress("SameParameterValue")
@Composable
private fun ProduceStateAwaitDisposeExample(viewModel: ProduceStateViewModel) {
    val currentPerson by produceState<Person?>(null, viewModel) {
        val disposable = viewModel.registerPersonObserver { person ->
            value = person
        }

        awaitDispose {
            disposable.dispose()
        }
    }
    when (val person = currentPerson) {
        null -> CircularProgressIndicator()
        else -> Text(stringResource(id = R.string.hello_with_args, person.name))
    }
}