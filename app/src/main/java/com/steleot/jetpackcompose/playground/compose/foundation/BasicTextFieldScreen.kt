package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.steleot.jetpackcompose.playground.navigation.graph.FoundationNavRoutes
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "foundation/BasicTextFieldScreen.kt"

@Composable
fun BasicTextFieldScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.BasicTextField,
        link = URL,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DefaultBasicTextField()
            StyledBasicTextField()
            ImeActionBasicTextField()
            PasswordKeyboardTypeBasicTextField()
            CursorBrushBasicTextField()
        }
    }
}

@Preview
@Composable
private fun DefaultBasicTextField(
    text: String = stringResource(id = R.string.jetpack)
) {
    val state = remember { mutableStateOf(TextFieldValue(text = text)) }
    BasicTextField(
        value = state.value,
        onValueChange = { state.value = it },
        textStyle = TextStyle(color = Color.Black),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    )
}

@Preview
@Composable
private fun StyledBasicTextField(text: String = stringResource(id = R.string.jetpack)) {
    val state = remember { mutableStateOf(TextFieldValue(text = text)) }
    BasicTextField(
        value = state.value,
        onValueChange = {
            state.value = it
        },
        textStyle = TextStyle(color = Color.Magenta, fontSize = 20.sp),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
    )
}

@Preview
@Composable
private fun ImeActionBasicTextField(text: String = stringResource(id = R.string.jetpack)) {
    val state = remember { mutableStateOf(TextFieldValue(text = text)) }
    BasicTextField(
        value = state.value,
        onValueChange = { value ->
            state.value = value
        },
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done,
        ),
    )
}

@Preview
@Composable
private fun PasswordKeyboardTypeBasicTextField(text: String = stringResource(id = R.string.jetpack)) {
    val state = remember { mutableStateOf(TextFieldValue(text = text)) }
    BasicTextField(
        value = state.value,
        onValueChange = { value ->
            state.value = value
        },
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        visualTransformation = PasswordVisualTransformation()
    )
}

@Preview
@Composable
private fun CursorBrushBasicTextField(text: String = stringResource(id = R.string.jetpack)) {
    val state = remember { mutableStateOf(TextFieldValue(text = text)) }
    BasicTextField(
        value = state.value,
        onValueChange = { value ->
            state.value = value
        },
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        cursorBrush = SolidColor(MaterialTheme.colors.secondary)
    )
}