package com.steleot.jetpackcompose.playground.compose

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Scaffold
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import com.google.accompanist.insets.statusBarsPadding
import com.steleot.jetpackcompose.playground.MainNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.BackArrow
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultListItem
import java.util.Locale
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.steleot.jetpackcompose.playground.compose.animation.routes as animationRoutes
import com.steleot.jetpackcompose.playground.compose.external.routes as externalRoutes
import com.steleot.jetpackcompose.playground.compose.foundation.routes as foundationRoutes
import com.steleot.jetpackcompose.playground.compose.foundationlayout.routes as foundationLayoutRoutes
import com.steleot.jetpackcompose.playground.compose.material.routes as materialRoutes
import com.steleot.jetpackcompose.playground.compose.materialicons.routes as materialIconsRoutes
import com.steleot.jetpackcompose.playground.compose.materialiconsextended.routes as materialIconsExtendedRoutes
import com.steleot.jetpackcompose.playground.compose.ui.routes as uiRoutes
import com.steleot.jetpackcompose.playground.compose.viewmodel.routes as viewModelRoutes

@Composable
fun SearchScreen(navController: NavHostController) {
    val viewModel: SearchViewModel = viewModel()

    val search: String by viewModel.search.collectAsState()
    val filteredRoutes: List<String> by viewModel.filteredRoutes.collectAsState()

    Scaffold(
        modifier = Modifier.statusBarsPadding(),
        topBar = {
            TopAppBar(
                title = {
                    TextField(
                        value = search,
                        onValueChange = { value -> viewModel.onSearchChange(value) },
                        textStyle = LocalTextStyle.current.copy(
                            fontSize = 14.sp
                        ),
                        colors = TextFieldDefaults.textFieldColors(
                            cursorColor = Color.White
                        )
                    )
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
        (animationRoutes +
                listOf(MainNavRoutes.ConstraintLayout) +
                foundationRoutes +
                foundationLayoutRoutes +
                materialRoutes +
                materialIconsRoutes +
                materialIconsExtendedRoutes +
                uiRoutes +
                viewModelRoutes +
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