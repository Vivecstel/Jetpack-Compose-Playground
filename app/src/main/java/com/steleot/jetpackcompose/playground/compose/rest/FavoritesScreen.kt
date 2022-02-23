package com.steleot.jetpackcompose.playground.compose.rest

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.helpers.FavoriteHelper
import com.steleot.jetpackcompose.playground.localproviders.LocalNavController
import com.steleot.jetpackcompose.playground.navigation.MainNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

const val ShouldReload = "ShouldReload"

@Composable
fun FavoritesScreen(
    viewModel: FavoritesViewModel,
) {
    val navController = LocalNavController.current
    val state: FavoritesUiState by viewModel.state.collectAsState()
    navController.currentBackStackEntry?.savedStateHandle?.let { savedStateHandle ->
        val shouldReload = savedStateHandle.get<Boolean?>(ShouldReload)
        savedStateHandle.remove<Boolean?>(ShouldReload)
        viewModel.updateFavoritesIfNeeded(shouldReload)
    }

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
                    LazyColumn {
                        items(content.data) { route ->
                            key(route) {
                                DefaultCardListItem(
                                    text = route,
                                ) {
                                    navController.navigate(route)
                                }
                            }
                        }
                    }
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
            initFavorites()
        }
    }

    private suspend fun initFavorites(
        initialSize: Int = -1
    ) {
        try {
            val favorites = favoriteHelper.getFavoriteSet(userId).sorted().toList()
            if (favorites.size != initialSize) {
                _state.value =
                    if (favorites.isEmpty()) FavoritesUiState.Empty(R.string.favorites_empty)
                    else FavoritesUiState.Content(favorites)
            }
        } catch (e: Exception) {
            _state.value =
                FavoritesUiState.Error(R.string.favorites_error)
        }
    }

    fun updateFavoritesIfNeeded(
        shouldReload: Boolean?
    ) {
        if (shouldReload == true) {
            viewModelScope.launch {
                val initialSize = (_state.value as? FavoritesUiState.Content)?.data?.size ?: 0
                initFavorites(initialSize)
            }
        }
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