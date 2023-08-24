package com.steleot.jetpackcompose.playground.compose.material3

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.steleot.jetpackcompose.playground.navigation.graph.Material3NavRoutes
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
import kotlinx.coroutines.launch

private const val URL = "material3/DatePickerScreen.kt"

@Composable
fun DatePickerScreen() {
    DefaultScaffold(
        title = Material3NavRoutes.DatePicker,
        link = URL,
    ) {
        DatePickerExample(paddingValues = it)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DatePickerExample(paddingValues: PaddingValues) {
    var showDatePicker by remember { mutableStateOf(false) }
    val snackState = remember { SnackbarHostState() }
    val snackScope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues = paddingValues),
        propagateMinConstraints = false,
        contentAlignment = Alignment.Center,
    ) {
        Button(
            onClick = { showDatePicker = true }
        ) {
            Text(stringResource(id = R.string.set_date))
        }
        SnackbarHost(hostState = snackState)
    }

    if (showDatePicker) {
        val datePickerState = rememberDatePickerState()
        val confirmEnabled =
            remember {
                derivedStateOf { datePickerState.selectedDateMillis != null }
            }
        val context = LocalContext.current
        DatePickerDialog(
            onDismissRequest = {
                showDatePicker = false
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        showDatePicker = false
                        snackScope.launch {
                            snackState.showSnackbar(
                                context.getString(
                                    R.string.selected_date,
                                    datePickerState.selectedDateMillis
                                )
                            )
                        }
                    },
                    enabled = confirmEnabled.value
                ) {
                    Text(stringResource(id = R.string.ok))
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        showDatePicker = false
                    }
                ) {
                    Text(stringResource(id = R.string.cancel))
                }
            }
        ) {
            DatePicker(state = datePickerState)
        }
    }
}