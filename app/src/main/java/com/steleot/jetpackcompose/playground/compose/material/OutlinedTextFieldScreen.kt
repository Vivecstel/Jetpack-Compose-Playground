package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.navigation.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val Url = "material/OutlinedTextFieldScreen.kt"

@Composable
fun OutlinedTextFieldScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.OutlinedTextField,
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
        label = { Text(stringResource(id = R.string.jetpack)) },
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
        label = { Text(stringResource(id = R.string.jetpack)) },
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
        label = { Text(stringResource(id = R.string.jetpack)) },
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
    var passwordHidden by remember { mutableStateOf(true) }
    OutlinedTextField(
        value = state.value,
        onValueChange = { value ->
            state.value = value
        },
        label = { Text(stringResource(id = R.string.jetpack)) },
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        visualTransformation = if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon = {
            IconButton(onClick = { passwordHidden = !passwordHidden }) {
                val (visibilityIcon, description) = if (passwordHidden)
                    Icons.Filled.Visibility to stringResource(id = R.string.show_password)
                else
                    Icons.Filled.VisibilityOff to stringResource(id = R.string.hide_password)
                Icon(imageVector = visibilityIcon, contentDescription = description)
            }
        }
    )
}
