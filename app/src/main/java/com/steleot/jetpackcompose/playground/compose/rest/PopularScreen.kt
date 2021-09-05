package com.steleot.jetpackcompose.playground.compose.rest

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.google.firebase.Timestamp
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
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
    val state: UiState by viewModel.state.collectAsState()

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
                is UiState.Loading -> {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
                is UiState.Error -> {
                    Text(
                        text = "Failed to retrieve the popular list. Please try again later.",
                        style = MaterialTheme.typography.body1,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .align(Alignment.Center)
                    )
                }
                is UiState.Content -> {
                    val uiState = state as UiState.Content
                    Column(modifier = Modifier.fillMaxSize()) {
                        uiState.date?.let {
                            Text(
                                uiState.date,
                                style = MaterialTheme.typography.body1,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .align(Alignment.CenterHorizontally)
                                    .padding(vertical = 16.dp)
                            )
                        }
                        MainScreenContent(navController, it, uiState.data)
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

    private val _state: MutableStateFlow<UiState> = MutableStateFlow(UiState.Loading)
    val state: StateFlow<UiState> = _state

    init {
        viewModelScope.launch {
            try {
                val querySnapshot = firebaseFirestore
                    .collection("popular")
                    .orderBy("date", Query.Direction.DESCENDING)
                    .get()
                    .await()
                val data = querySnapshot.first().data
                _state.value = UiState.Content(
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
                _state.value = UiState.Error
            }
        }
    }
}

sealed class UiState {
    object Loading : UiState()
    object Error : UiState()
    class Content(
        val data: List<String>,
        val date: String?,
    ) : UiState()
}