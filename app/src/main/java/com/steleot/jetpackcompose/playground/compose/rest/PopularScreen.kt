package com.steleot.jetpackcompose.playground.compose.rest

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.google.firebase.Timestamp
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultTopAppBar
import com.steleot.jetpackcompose.playground.navigation.MainNavRoutes
import com.steleot.jetpackcompose.playground.utils.monthDate
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import timber.log.Timber
import javax.inject.Inject

@Composable
fun PopularScreen(
    viewModel: PopularViewModel,
    navController: NavHostController,
) {
    val state: PopularUiState by viewModel.state.collectAsState()

    DefaultScaffold(
        topBar = {
            DefaultTopAppBar(
                title = MainNavRoutes.Popular,
                navigateToSearch = {
                    navController.navigate(MainNavRoutes.Search)
                }
            )
        }
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            when (state) {
                is PopularUiState.Loading -> {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
                is PopularUiState.Error -> {
                    val error = state as PopularUiState.Error
                    Text(
                        text = stringResource(id = error.messageRes),
                        style = MaterialTheme.typography.body1,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .align(Alignment.Center)
                    )
                }
                is PopularUiState.Content -> {
                    val content = state as PopularUiState.Content
                    Column(modifier = Modifier.fillMaxSize()) {
                        content.date?.let {
                            Text(
                                content.date,
                                style = MaterialTheme.typography.body1,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .align(Alignment.CenterHorizontally)
                                    .padding(vertical = 16.dp)
                            )
                        }
                        MainScreenContent(navController, it, content.data)
                    }
                }
            }
        }
    }
}

@HiltViewModel
class PopularViewModel @Inject constructor(
    private val firebaseFirestore: FirebaseFirestore,
) : ViewModel() {

    private val _state: MutableStateFlow<PopularUiState> = MutableStateFlow(PopularUiState.Loading)
    val state: StateFlow<PopularUiState> = _state

    init {
        viewModelScope.launch {
            try {
                val snapshot = firebaseFirestore
                    .collection("popular")
                    .orderBy("date", Query.Direction.DESCENDING)
                    .get()
                    .await()
                val data = snapshot.first().data
                _state.value = PopularUiState.Content(
                    data = data.filterNot { it.key == "date" }
                        .toSortedMap { o1, o2 ->
                            o1.toInt().compareTo(o2.toInt())
                        }
                        .map { it.value.toString() }
                        .toList(),
                    date = (data["date"] as? Timestamp)?.toDate()?.monthDate
                )
            } catch (e: Exception) {
                Timber.e(e)
                _state.value =
                    PopularUiState.Error(R.string.popular_error)
            }
        }
    }
}

sealed class PopularUiState {
    object Loading : PopularUiState()
    class Error(
        @StringRes val messageRes: Int,
    ) : PopularUiState()

    class Content(
        val data: List<String>,
        val date: String?,
    ) : PopularUiState()
}