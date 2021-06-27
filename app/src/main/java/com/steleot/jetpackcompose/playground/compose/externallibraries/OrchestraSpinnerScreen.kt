package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
//import com.skydoves.orchestra.spinner.Spinner
import com.steleot.jetpackcompose.playground.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold

private const val Url = "external/OrchestraSpinnerScreen.kt"

@Composable
fun OrchestraSpinnerScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.OrchestraSpinner,
        link = Url,
    ) {
//        OrchestraSpinnerExample()
    }
}

/*
@Composable
private fun OrchestraSpinnerExample() {
    val coffeeList = remember { listOf("Americano", "Cold Brew", "Espresso", "Latte") }
    var selectedItem by remember { mutableStateOf("Choose your coffee") }
    Spinner(
        text = selectedItem,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(MaterialTheme.colors.primary),
        itemList = coffeeList,
        color = MaterialTheme.colors.onPrimary,
        style = MaterialTheme.typography.body2,
        textAlign = TextAlign.Center,
        dividerColor = MaterialTheme.colors.onPrimary.copy(0.8f),
        overflow = TextOverflow.Ellipsis,
        maxLines = 1,
        spinnerPadding = 16.dp,
        spinnerBackgroundColor = MaterialTheme.colors.onBackground,
        onSpinnerItemSelected = { _, item ->
            selectedItem = item
        }
    )
}*/
