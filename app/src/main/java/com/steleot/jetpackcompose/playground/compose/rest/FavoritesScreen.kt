package com.steleot.jetpackcompose.playground.compose.rest

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.compose.reusable.CenteredCircularProgressIndicator
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultTopAppBar
import com.steleot.jetpackcompose.playground.compose.reusable.ErrorText
import com.steleot.jetpackcompose.playground.helpers.FavoriteHelper
import com.steleot.jetpackcompose.playground.localproviders.LocalNavController
import com.steleot.jetpackcompose.playground.navigation.MainNavRoutes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@Composable
fun FavoritesScreen(
    viewModel: FavoritesViewModel,
) {
    val navController = LocalNavController.current
    val state: FavoritesUiState by viewModel.state.collectAsState()
    val shouldReload =
        navController.currentBackStackEntry?.savedStateHandle?.getLiveData<Boolean>("STELIOS")
            ?.observeAsState()
    Timber.tag("STELIOS").d("shouldReload: $shouldReload")

    DefaultScaffold(
        topBar = {
            DefaultTopAppBar(
                title = MainNavRoutes.Favorites,
            )
        }
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            when (state) {
                is FavoritesUiState.Loading -> {
                    CenteredCircularProgressIndicator()
                }
                is FavoritesUiState.Error -> {
                    val error = state as FavoritesUiState.Error
                    ErrorText(stringResource(id = error.messageRes), Modifier.padding(16.dp))
                }
                is FavoritesUiState.Empty -> {
                    val empty = state as FavoritesUiState.Empty
                    ErrorText(stringResource(id = empty.messageRes), Modifier.padding(16.dp))
                }
                is FavoritesUiState.Content -> {
                    val content = state as FavoritesUiState.Content
                    Timber.tag("STELIOS").d("${content.data}")
                    MainScreenContent(it, content.data)
                }
            }
        }
    }
}

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val favoriteHelper: FavoriteHelper,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val userId: String = savedStateHandle[UserId] ?: ""
    private val _state: MutableStateFlow<FavoritesUiState> =
        MutableStateFlow(FavoritesUiState.Loading)
    val state: StateFlow<FavoritesUiState> = _state

    init {
        viewModelScope.launch {
            try {
                val favorites = favoriteHelper.getFavoriteSet(userId).sorted().toList()
                updateState(favorites)
            } catch (e: Exception) {
                _state.value =
                    FavoritesUiState.Error(R.string.popular_error)
            }
        }
    }

    private fun updateState(favorites: List<String>) {
        _state.value =
            if (favorites.isEmpty()) FavoritesUiState.Empty(R.string.favorites_empty)
            else FavoritesUiState.Content(favorites)
    }

    companion object {
        private const val UserId = "userId"
    }
}

sealed class FavoritesUiState {
    object Loading : FavoritesUiState()
    class Error(
        @StringRes val messageRes: Int,
    ) : FavoritesUiState()

    class Empty(
        @StringRes val messageRes: Int,
    ) : FavoritesUiState()

    class Content(
        val data: List<String>,
    ) : FavoritesUiState()
}