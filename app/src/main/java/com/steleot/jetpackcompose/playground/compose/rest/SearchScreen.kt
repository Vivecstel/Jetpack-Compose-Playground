package com.steleot.jetpackcompose.playground.compose.rest

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandIn
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.insets.systemBarsPadding
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.compose.reusable.ribbonRoutes
import com.steleot.jetpackcompose.playground.localproviders.LocalNavController
import com.steleot.jetpackcompose.playground.navigation.graph.MainNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.BackArrowIconButton
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultCardListItem
import com.steleot.jetpackcompose.playground.utils.capitalizeFirstLetter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.steleot.jetpackcompose.playground.compose.activity.routes as activityRoutes
import com.steleot.jetpackcompose.playground.compose.animation.routes as animationRoutes
import com.steleot.jetpackcompose.playground.compose.constraintlayout.routes as constraintLayoutRoutes
import com.steleot.jetpackcompose.playground.compose.customexamples.routes as customExamplesRoutes
import com.steleot.jetpackcompose.playground.compose.externallibraries.routes as externalLibrariesRoutes
import com.steleot.jetpackcompose.playground.compose.foundation.routes as foundationRoutes
import com.steleot.jetpackcompose.playground.compose.material.routes as materialRoutes
import com.steleot.jetpackcompose.playground.compose.material3.routes as material3Routes
import com.steleot.jetpackcompose.playground.compose.materialicons.routes as materialIconsRoutes
import com.steleot.jetpackcompose.playground.compose.materialiconsextended.routes as materialIconsExtendedRoutes
import com.steleot.jetpackcompose.playground.compose.runtime.routes as runtimeRoutes
import com.steleot.jetpackcompose.playground.compose.ui.routes as uiRoutes
import com.steleot.jetpackcompose.playground.compose.viewmodel.routes as viewModelRoutes

@OptIn(ExperimentalAnimationApi::class, ExperimentalComposeUiApi::class)
@Composable
fun SearchScreen() {
    val viewModel: SearchViewModel = viewModel()
    val search: TextFieldValue by viewModel.search.collectAsState()
    val filteredRoutes: List<SearchData> by viewModel.filteredRoutes.collectAsState()
    var visible by rememberSaveable { mutableStateOf(false) }
    val keyboardController = LocalSoftwareKeyboardController.current
    val navController = LocalNavController.current

    LaunchedEffect(Unit) {
        visible = true
    }

    Scaffold(
        modifier = Modifier.systemBarsPadding(),
        topBar = {
            TopAppBar(
                title = {
                    AnimatedVisibility(
                        visible = visible,
                        enter = expandIn(
                            expandFrom = Alignment.BottomStart,
                            animationSpec = tween(
                                250,
                                delayMillis = 250,
                                easing = LinearOutSlowInEasing
                            )
                        )
                    ) {
                        SearchTextField(search, keyboardController) {
                            viewModel.onSearchChange(it)
                        }
                    }
                },
                navigationIcon = {
                    BackArrowIconButton()
                },
                modifier = Modifier.heightIn(64.dp),
                backgroundColor = MaterialTheme.colors.primary
            )
        },
    ) {
        LazyColumn {
            items(filteredRoutes) { data ->
                DefaultCardListItem(
                    text = getListAnnotatedString(
                        data.route.capitalizeFirstLetter(),
                        search.text,
                        MaterialTheme.colors.secondary
                    ),
                    secondaryText = AnnotatedString(
                        data.category.capitalizeFirstLetter()
                    ),
                    hasRibbon = data.hasRibbon
                ) {
                    keyboardController?.hide()
                    navController.navigate(data.route)
                }
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun SearchTextField(
    searchText: TextFieldValue,
    keyboardController: SoftwareKeyboardController?,
    onSearchTextChange: (TextFieldValue) -> Unit
) {
    val focusRequester = FocusRequester()
    TextField(
        value = searchText,
        onValueChange = {
            onSearchTextChange(it)
        },
        trailingIcon = {
            if (searchText.text.isNotEmpty()) {
                IconButton(
                    onClick = {
                        onSearchTextChange(searchText.copy(text = ""))
                    }
                ) {
                    Icon(
                        Icons.Filled.Close,
                        contentDescription = stringResource(id = R.string.clear_text),
                        tint = MaterialTheme.colors.onPrimary
                    )
                }
            }
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = { keyboardController?.hide() }
        ),
        textStyle = LocalTextStyle.current.copy(
            fontSize = 16.sp
        ),
        colors = TextFieldDefaults.textFieldColors(
            cursorColor = MaterialTheme.colors.onPrimary
        ),
        modifier = Modifier
            .fillMaxWidth()
            .focusRequester(focusRequester)
            .padding(end = 16.dp)
    )
    DisposableEffect(Unit) {
        focusRequester.requestFocus()
        onDispose { }
    }
}

private fun getListAnnotatedString(
    text: String,
    search: String,
    highlightedColor: Color,
): AnnotatedString {
    val startIndex = text.indexOf(search, ignoreCase = true)
    val endIndex = startIndex + search.length
    return with(AnnotatedString.Builder()) {
        append(text.substring(0 until startIndex))
        withStyle(SpanStyle(color = highlightedColor)) {
            append(text.substring(startIndex until endIndex))
        }
        append(text.substring(endIndex until text.length))
        toAnnotatedString()
    }
}

class SearchViewModel : ViewModel() {

    private val routes: List<SearchData> = listOf(
        MainNavRoutes.Activity to activityRoutes,
        MainNavRoutes.Animation to animationRoutes,
        MainNavRoutes.ConstraintLayout to constraintLayoutRoutes,
        MainNavRoutes.CustomExamples to customExamplesRoutes,
        MainNavRoutes.ExternalLibraries to externalLibrariesRoutes,
        MainNavRoutes.Foundation to foundationRoutes,
        MainNavRoutes.Material to materialRoutes,
        MainNavRoutes.Material3 to material3Routes,
        MainNavRoutes.MaterialIcons to materialIconsRoutes,
        MainNavRoutes.MaterialIConsExtended to materialIconsExtendedRoutes,
        MainNavRoutes.Navigation to listOf(MainNavRoutes.Navigation),
        MainNavRoutes.Paging to listOf(MainNavRoutes.Paging),
        MainNavRoutes.Runtime to runtimeRoutes,
        MainNavRoutes.Ui to uiRoutes,
        MainNavRoutes.ViewModel to viewModelRoutes
    ).asSequence().flatMap { pair ->
        pair.second.map { pair.first to it }
    }.map {
        SearchData(
            route = it.second,
            category = it.first,
            hasRibbon = it.second in ribbonRoutes
        )
    }.sortedBy { it.route }.toList()

    private val _search = MutableStateFlow(TextFieldValue(""))
    val search: StateFlow<TextFieldValue> = _search

    private val _filteredRoutes = MutableStateFlow(routes)
    val filteredRoutes: StateFlow<List<SearchData>> = _filteredRoutes

    fun onSearchChange(search: TextFieldValue) {
        _search.value = search
        _filteredRoutes.value = routes.filter {
            it.route.contains(search.text, ignoreCase = true)
        }
    }
}

class SearchData(
    val route: String,
    val category: String,
    val hasRibbon: Boolean = false
)
