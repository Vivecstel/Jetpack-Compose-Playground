package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.foundation.text2.input.TextFieldState
import androidx.compose.foundation.verticalScroll
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.steleot.jetpackcompose.playground.navigation.graph.FoundationNavRoutes
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "foundation/BasicTextField2Screen.kt"

@Composable
fun BasicTextField2Screen() {
    DefaultScaffold(
        title = FoundationNavRoutes.BasicTextField2,
        link = URL,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = it)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DefaultBasicTextField2()
            StyledBasicTextField2()
            ImeActionBasicTextField2()
            CursorBrushBasicTextField2()
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
private fun DefaultBasicTextField2(
    text: String = stringResource(id = R.string.jetpack)
) {
    val state = remember { mutableStateOf(TextFieldState(initialText = text)) }
    BasicTextField2(
        state = state.value,
        textStyle = TextStyle(color = Color.Black),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
private fun StyledBasicTextField2(text: String = stringResource(id = R.string.jetpack)) {
    val state = remember { mutableStateOf(TextFieldState(initialText = text)) }
    BasicTextField2(
        state = state.value,
        textStyle = TextStyle(color = Color.Magenta, fontSize = 20.sp),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
private fun ImeActionBasicTextField2(text: String = stringResource(id = R.string.jetpack)) {
    val state = remember { mutableStateOf(TextFieldState(initialText = text)) }
    BasicTextField2(
        state = state.value,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done,
        ),
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
private fun CursorBrushBasicTextField2(text: String = stringResource(id = R.string.jetpack)) {
    val state = remember { mutableStateOf(TextFieldState(initialText = text)) }
    BasicTextField2(
        state = state.value,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        cursorBrush = SolidColor(MaterialTheme.colors.secondary)
    )
}