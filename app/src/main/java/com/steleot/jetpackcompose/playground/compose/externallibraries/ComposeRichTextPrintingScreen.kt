package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Print
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.ExternalLibrariesNavRoutes
import com.zachklipp.richtext.ui.printing.Printable
import com.zachklipp.richtext.ui.printing.hideWhenPrinting
import com.zachklipp.richtext.ui.printing.rememberPrintableController
import com.zachklipp.richtext.ui.printing.responsivePadding

private const val Url = "external/ComposeRichTextPrintingScreen.kt"

@Composable
fun ComposeRichTextPrintingScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.ComposeRichTextPrinting,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
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
                    "Jetpack Compose Playground",
                    style = MaterialTheme.typography.h3,
                    fontWeight = Bold
                )
                Spacer(Modifier.size(24.dp))
                (1..10).forEach { number ->
                    SectionWithLoremIpsum(number)
                }
                Spacer(Modifier.size(16.dp))
                OutlinedButton(
                    onClick = {
                        printableController.print(
                            "Jetpack Compose Playground document"
                        )
                    },
                    modifier = Modifier.padding(vertical = 8.dp).hideWhenPrinting(),
                ) {
                    Icon(
                        Icons.Outlined.Print,
                        contentDescription = "Print",
                        modifier = Modifier.size(16.dp),
                        tint = MaterialTheme.colors.onPrimary
                    )
                    Text(
                        text = "Print document",
                        modifier = Modifier.padding(8.dp),
                        color = MaterialTheme.colors.onPrimary
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
        loremIpsum,
        style = MaterialTheme.typography.body2,
    )
}

private const val loremIpsum = """
    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut 
    labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco 
    laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in 
    voluptate velit esse cillum dolore eu fugiat nulla pariatur. 
    Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt 
    mollit anim id est laborum.
"""