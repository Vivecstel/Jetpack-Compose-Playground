package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Icon
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.OutlinedButton
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Print
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
import com.zachklipp.richtext.ui.printing.Printable
import com.zachklipp.richtext.ui.printing.hideWhenPrinting
import com.zachklipp.richtext.ui.printing.rememberPrintableController
import com.zachklipp.richtext.ui.printing.responsivePadding

private const val URL = "externallibraries/ComposeRichTextPrintingScreen.kt"

@Composable
fun ComposeRichTextPrintingScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.ComposeRichTextPrinting,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues = it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DocumentScreenExample()
        }
    }
}

@Composable
private fun DocumentScreenExample() {
    val printableController = rememberPrintableController()
    val document = stringResource(id = R.string.document)
    Column(Modifier.verticalScroll(rememberScrollState())) {
        Printable(
            printableController,
            pageDpi = 96,
            modifier = Modifier.responsivePadding(
                600.dp to 32.dp,
                Dp.Infinity to 96.dp
            )
        ) {
            Column {
                Text(
                    stringResource(id = R.string.app_name),
                    style = MaterialTheme.typography.h3,
                    fontWeight = Bold
                )
                Spacer(Modifier.size(24.dp))
                for (i in 1..10) {
                    SectionWithLoremIpsum(i)
                }
                Spacer(Modifier.size(16.dp))
                OutlinedButton(
                    onClick = {
                        printableController.print(document)
                    },
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .hideWhenPrinting(),
                ) {
                    Icon(
                        Icons.Outlined.Print,
                        contentDescription = stringResource(id = R.string.print),
                        modifier = Modifier.size(16.dp),
                        tint = MaterialTheme.colors.primary
                    )
                    Text(
                        text = stringResource(id = R.string.print_document),
                        modifier = Modifier.padding(8.dp),
                        color = MaterialTheme.colors.primary
                    )
                }
            }
        }
    }
}

@Composable
private fun SectionWithLoremIpsum(
    sectionNumber: Int,
) {
    Text(
        "Section #$sectionNumber",
        style = MaterialTheme.typography.h6,
        fontWeight = Bold,
        modifier = Modifier.padding(horizontal = 16.dp)
    )
    Text(
        stringResource(id = R.string.lorem_ipsum),
        style = MaterialTheme.typography.body2,
    )
}