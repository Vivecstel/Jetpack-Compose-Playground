package com.steleot.jetpackcompose.playground.compose.rest

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.api.GitHubService
import com.steleot.jetpackcompose.playground.compose.reusable.CenteredCircularProgressIndicator
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultTopAppBar
import com.steleot.jetpackcompose.playground.compose.reusable.ErrorText
import com.steleot.jetpackcompose.playground.navigation.MainNavRoutes
import com.steleot.jetpackcompose.playground.utils.releaseString
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ReleaseNotesScreen(
    viewModel: ReleaseNotesViewModel,
) {
    val state: ReleaseNotesUiState by viewModel.state.collectAsState()
    val uriHandler = LocalUriHandler.current

    DefaultScaffold(
        topBar = {
            DefaultTopAppBar(
                title = MainNavRoutes.ReleaseNotes,
            )
        }
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            when (state) {
                is ReleaseNotesUiState.Loading -> {
                    CenteredCircularProgressIndicator()
                }
                is ReleaseNotesUiState.Error -> {
                    val error = state as ReleaseNotesUiState.Error
                    ErrorText(stringResource(id = error.messageRes), Modifier.padding(16.dp))
                }
                is ReleaseNotesUiState.Content -> {
                    val content = state as ReleaseNotesUiState.Content
                    LazyColumn {
                        items(content.data) { release ->
                            Card(
                                onClick = {
                                    try {
                                        uriHandler.openUri(release.url)
                                    } catch (e: Exception) {
                                        Timber.e(e, "Failed to open uri")
                                    }
                                },
                                modifier = Modifier
                                    .padding(horizontal = 16.dp, vertical = 4.dp),
                                elevation = 4.dp,
                                backgroundColor = MaterialTheme.colors.primary
                            ) {
                                Column(
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .fillMaxWidth()
                                ) {
                                    Text(
                                        text = with(AnnotatedString.Builder()) {
                                            withStyle(
                                                SpanStyle(
                                                    fontWeight = FontWeight.Bold,
                                                    textDecoration = TextDecoration.Underline
                                                )
                                            ) {
                                                append(release.name)
                                            }
                                            withStyle(SpanStyle(fontSize = 12.sp)) {
                                                append(" - ")
                                                append(release.createdDate)
                                            }
                                            toAnnotatedString()
                                        },
                                        style = MaterialTheme.typography.body1,
                                    )
                                    Text(
                                        text = release.body,
                                        style = MaterialTheme.typography.caption,
                                        modifier = Modifier.padding(top = 8.dp)
                                    )
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
class ReleaseNotesViewModel @Inject constructor(
    private val repository: ReleaseNotesRepository
) : ViewModel() {

    private val _state: MutableStateFlow<ReleaseNotesUiState> =
        MutableStateFlow(ReleaseNotesUiState.Loading)
    val state: StateFlow<ReleaseNotesUiState> = _state

    init {
        viewModelScope.launch {
            repository.getReleases().collect { result ->
                if (result.throwable != null) {
                    _state.value = ReleaseNotesUiState.Error(R.string.releases_error)
                } else {
                    _state.value = ReleaseNotesUiState.Content(
                        result.data
                    )
                }
            }
        }
    }
}

sealed class ReleaseNotesUiState {
    object Loading : ReleaseNotesUiState()
    class Error(
        @StringRes val messageRes: Int,
    ) : ReleaseNotesUiState()

    class Content(
        val data: List<ReleaseDomain>,
    ) : ReleaseNotesUiState()
}

private const val User = "Vivecstel"
private const val Repo = "Jetpack-Compose-Playground"

class ReleaseNotesRepository @Inject constructor(
    private val service: GitHubService
) {

    suspend fun getReleases(): Flow<ResultWrapper> {
        return flow {
            emit(service.getReleases(User, Repo))
        }.map {
            ResultWrapper(it.map { release ->
                Timber.d(release.toString())
                ReleaseDomain(
                    release.name,
                    release.body,
                    release.htmlUrl,
                    release.createdAt.releaseString ?: "-"
                )
            })
        }.catch { throwable ->
            Timber.e(throwable)
            emit(ResultWrapper(throwable = throwable))
        }
    }
}

data class ResultWrapper(
    val data: List<ReleaseDomain> = listOf(),
    val throwable: Throwable? = null
)

data class ReleaseDomain(
    val name: String,
    val body: String,
    val url: String,
    val createdDate: String,
)