package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.MaterialNavRoutes

private const val Url = "material/TextFieldScreen.kt"

@Composable
fun TextFieldScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.TextField,
        link = Url,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DefaultTextField()
            BackgroundColorTextField()
            StyledTextField()
            ImeActionTextField()
            PasswordKeyboardTypeTextField()
            ShapedTextField()
        }
    }
}

@Preview
@Composable
private fun DefaultTextField(
    text: String = stringResource(id = R.string.jetpack)
) {
    val state = remember { mutableStateOf(TextFieldValue(text = text)) }
    TextField(
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
private fun BackgroundColorTextField(text: String = stringResource(id = R.string.jetpack)) {
    val state = remember { mutableStateOf(TextFieldValue(text = text)) }
    TextField(
        value = state.value,
        onValueChange = { state.value = it },
        textStyle = TextStyle(color = Color.Black),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Magenta
        ),
    )
}

@Preview
@Composable
private fun StyledTextField(text: String = stringResource(id = R.string.jetpack)) {
    val state = remember { mutableStateOf(TextFieldValue(text = text)) }
    TextField(
        value = state.value,
        onValueChange = { value ->
            state.value = value
        },
        textStyle = TextStyle(color = Color.Magenta, fontSize = 20.sp),
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Blue,
        ),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
    )
}

@Preview
@Composable
private fun ImeActionTextField(text: String = stringResource(id = R.string.jetpack)) {
    val state = remember { mutableStateOf(TextFieldValue(text = text)) }
    TextField(
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
private fun PasswordKeyboardTypeTextField(text: String = stringResource(id = R.string.jetpack)) {
    val state = remember { mutableStateOf(TextFieldValue(text = text)) }
    TextField(
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
private fun ShapedTextField(text: String = stringResource(id = R.string.jetpack)) {
    val state = remember { mutableStateOf(TextFieldValue(text = text)) }
    TextField(
        value = state.value,
        onValueChange = { state.value = it },
        textStyle = TextStyle(color = Color.Black),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        shape = CutCornerShape(8.dp)
    )
}