package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.steleot.jetpackcompose.playground.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.Locale

private const val Url = "material/OutlinedTextFieldScreen.kt"

@Composable
fun OutlinedTextFieldScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.OutlinedTextField.capitalize(Locale.getDefault()),
        link = Url,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DefaultOutlinedTextField()
            StyledOutlinedTextField()
            ImeActionOutlinedTextField()
            PasswordKeyboardTypeOutlinedTextField()
        }
    }
}

@Preview
@Composable
private fun DefaultOutlinedTextField() {
    val state = remember { mutableStateOf(TextFieldValue(text = "")) }
    OutlinedTextField(
        value = state.value,
        onValueChange = { state.value = it },
        label = { Text("Jetpack") },
        textStyle = TextStyle(color = Color.Black),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    )
}

@Preview
@Composable
private fun StyledOutlinedTextField() {
    val state = remember { mutableStateOf(TextFieldValue(text = "")) }
    OutlinedTextField(
        value = state.value,
        onValueChange = { value ->
            state.value = value
        },
        label = { Text("Jetpack") },
        textStyle = TextStyle(color = Color.Magenta, fontSize = 20.sp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.Blue
        ),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
    )
}

@Preview
@Composable
private fun ImeActionOutlinedTextField() {
    val state = remember { mutableStateOf(TextFieldValue(text = "")) }
    OutlinedTextField(
        value = state.value,
        onValueChange = { value ->
            state.value = value
        },
        label = { Text("Jetpack") },
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done,
        ),
    )
}

@Composable
private fun PasswordKeyboardTypeOutlinedTextField() {
    val state = remember { mutableStateOf(TextFieldValue(text = "")) }
    OutlinedTextField(
        value = state.value,
        onValueChange = { value ->
            state.value = value
        },
        label = { Text("Jetpack") },
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        visualTransformation = PasswordVisualTransformation()
    )
}
