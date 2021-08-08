package com.steleot.jetpackcompose.playground.compose

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
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.google.accompanist.insets.systemBarsPadding
import com.steleot.jetpackcompose.playground.compose.reusable.BackArrow
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultListItem
import com.steleot.jetpackcompose.playground.compose.reusable.ribbonRoutes
import com.steleot.jetpackcompose.playground.navigation.MainNavRoutes
import com.steleot.jetpackcompose.playground.utils.capitalizeFirstLetter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.collections.plus
import kotlin.collections.sorted
import com.steleot.jetpackcompose.playground.compose.activity.routes as activityRoutes
import com.steleot.jetpackcompose.playground.compose.animation.routes as animationRoutes
import com.steleot.jetpackcompose.playground.compose.constraintlayout.routes as constraintLayoutRoutes
import com.steleot.jetpackcompose.playground.compose.customexamples.routes as customExamplesRoutes
import com.steleot.jetpackcompose.playground.compose.externallibraries.routes as externalRoutes
import com.steleot.jetpackcompose.playground.compose.foundation.routes as foundationRoutes
import com.steleot.jetpackcompose.playground.compose.foundationlayout.routes as foundationLayoutRoutes
import com.steleot.jetpackcompose.playground.compose.material.routes as materialRoutes
import com.steleot.jetpackcompose.playground.compose.materialicons.routes as materialIconsRoutes
import com.steleot.jetpackcompose.playground.compose.materialiconsextended.routes as materialIconsExtendedRoutes
import com.steleot.jetpackcompose.playground.compose.runtime.routes as runtimeRoutes
import com.steleot.jetpackcompose.playground.compose.ui.routes as uiRoutes
import com.steleot.jetpackcompose.playground.compose.viewmodel.routes as viewModelRoutes

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun SearchScreen(navController: NavHostController) {
    val viewModel: SearchViewModel = viewModel()
    val search: String by viewModel.search.collectAsState()
    val filteredRoutes: List<Pair<String, Boolean>> by viewModel.filteredRoutes.collectAsState()
    var visible by rememberSaveable { mutableStateOf(false) }

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
                        SearchTextField(search) {
                            viewModel.onSearchChange(it)
                        }
                    }
                },
                navigationIcon = {
                    BackArrow()
                },
                modifier = Modifier.heightIn(64.dp)
            )
        },
    ) {
        LazyColumn {
            items(filteredRoutes) { (route, shouldShowRibbon) ->
                DefaultListItem(
                    text = getListAnnotatedString(
                        route.capitalizeFirstLetter(), search, MaterialTheme.colors.secondary
                    ),
                    shouldShowRibbon = shouldShowRibbon
                ) {
                    navController.navigate(route)
                }
            }
        }
    }
}

@Composable
private fun SearchTextField(
    searchText: String, onSearchTextChange: (String) -> Unit
) {
    val focusRequester = FocusRequester()
    TextField(
        value = searchText,
        onValueChange = { onSearchTextChange(it) },
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

    private val routes =
        (activityRoutes +
                animationRoutes +
                constraintLayoutRoutes +
                foundationRoutes +
                foundationLayoutRoutes +
                materialRoutes +
                materialIconsRoutes +
                materialIconsExtendedRoutes +
                listOf(MainNavRoutes.Navigation) +
                listOf(MainNavRoutes.Paging) +
                runtimeRoutes +
                uiRoutes +
                viewModelRoutes +
                customExamplesRoutes +
                externalRoutes).sorted().map { route ->
            route to (route in ribbonRoutes)
        }
    private val _search = MutableStateFlow("")
    val search: StateFlow<String> = _search

    private val _filteredRoutes = MutableStateFlow(routes)
    val filteredRoutes: StateFlow<List<Pair<String, Boolean>>> = _filteredRoutes

    fun onSearchChange(search: String) {
        _search.value = search
        _filteredRoutes.value = routes.filter { it.first.contains(search, ignoreCase = true) }
    }
}