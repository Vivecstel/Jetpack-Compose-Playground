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
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Scaffold
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.google.accompanist.insets.systemBarsPadding
import com.steleot.jetpackcompose.playground.MainNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.BackArrow
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultListItem
import java.util.Locale
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
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
import com.steleot.jetpackcompose.playground.compose.ui.routes as uiRoutes
import com.steleot.jetpackcompose.playground.compose.viewmodel.routes as viewModelRoutes

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun SearchScreen(navController: NavHostController) {
    val viewModel: SearchViewModel = viewModel()
    val search: String by viewModel.search.collectAsState()
    val filteredRoutes: List<String> by viewModel.filteredRoutes.collectAsState()
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
                        visible = true,
                        initiallyVisible = visible,
                        enter = expandIn(
                            expandFrom = Alignment.BottomStart,
                            animationSpec = tween(
                                250,
                                delayMillis = 250,
                                easing = LinearOutSlowInEasing
                            )
                        )
                    ) {
                        TextField(
                            value = search,
                            onValueChange = { value -> viewModel.onSearchChange(value) },
                            textStyle = LocalTextStyle.current.copy(
                                fontSize = 16.sp
                            ),
                            colors = TextFieldDefaults.textFieldColors(
                                cursorColor = Color.White
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 16.dp)
                        )
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
            items(filteredRoutes) { item ->
                DefaultListItem(
                    text = getListAnnotatedString(
                        item.capitalize(Locale.getDefault()), search
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    navController.navigate(item)
                }
            }
        }
    }
}

private fun getListAnnotatedString(
    text: String,
    search: String,
): AnnotatedString {
    val startIndex = text.indexOf(search, ignoreCase = true)
    val endIndex = startIndex + search.length
    return with(AnnotatedString.Builder()) {
        append(text.substring(0 until startIndex))
        withStyle(SpanStyle(color = Color.Red)) {
            append(if (startIndex == 0) search.capitalize(Locale.getDefault()) else search)
        }
        append(text.substring(endIndex until text.length))
        toAnnotatedString()
    }
}

class SearchViewModel : ViewModel() {

    private val routes: List<String> =
        (activityRoutes +
                animationRoutes +
                constraintLayoutRoutes +
                listOf(MainNavRoutes.Paging) +
                foundationRoutes +
                foundationLayoutRoutes +
                materialRoutes +
                materialIconsRoutes +
                materialIconsExtendedRoutes +
                uiRoutes +
                viewModelRoutes +
                customExamplesRoutes +
                externalRoutes).sorted()
    private val _search = MutableStateFlow("")
    val search: StateFlow<String> = _search

    private val _filteredRoutes = MutableStateFlow(routes)
    val filteredRoutes: StateFlow<List<String>> = _filteredRoutes

    fun onSearchChange(search: String) {
        _search.value = search
        _filteredRoutes.value = routes.filter { search in it }
    }
}