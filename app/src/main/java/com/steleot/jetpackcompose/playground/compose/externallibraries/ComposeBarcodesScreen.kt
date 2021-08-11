package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.simonsickle.compose.barcodes.Barcode
import com.simonsickle.compose.barcodes.BarcodeType
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.ExternalLibrariesNavRoutes

private const val Url = "externallibraries/ComposeBarcodesScreen.kt"
private const val BarcodeUrl = "https://github.com/Vivecstel/Jetpack-Compose-Playground/tree/master"

@Composable
fun ComposeBarcodesScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.ComposeBarcodes,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Barcode(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                width = 150.dp,
                height = 150.dp,
                type = BarcodeType.QR_CODE,
                value = BarcodeUrl
            )
        }
    }
}