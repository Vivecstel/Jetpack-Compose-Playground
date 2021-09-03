package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.ExternalLibrariesNavRoutes
import com.zachklipp.richtext.ui.*
import com.zachklipp.richtext.ui.string.richTextString

private const val Url = "externallibraries/ComposeRichTextUiScreen.kt"

@Composable
fun ComposeRichTextUiScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.ComposeRichTextUi,
        link = Url,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BasicRichTextExample()
        }
    }
}

@Composable
private fun BasicRichTextExample() {
    RichText(modifier = Modifier.padding(16.dp)) {
        Heading(0, "Paragraphs")
        richTextString {
        }
        Text("Simple paragraph.")
        Text("Paragraph with\nmultiple lines.")
        Text("Paragraph with really long line that should be getting wrapped.")
        Heading(0, "Horizontal Line")
        Text("Paragraph with really long line that should be getting wrapped.")
        Text("Above line")
        HorizontalRule()
        Text("Below line")

        Heading(0, "Code Block")
        CodeBlock(
            """
      {
        "Hello": "world!"
      }
    """.trimIndent()
        )
        Heading(0, "Block Quote")
        BlockQuote {
            Text("These paragraphs are quoted.")
            Text("More text.")
            BlockQuote {
                Text("Nested block quote.")
            }
        }
        Heading(0, "Table")
        Table(headerRow = {
            cell { Text("Column 1") }
            cell { Text("Column 2") }
        }) {
            row {
                cell { Text("Hello") }
                cell {
                    CodeBlock("Foo bar")
                }
            }
            row {
                cell {
                    BlockQuote {
                        Text("Stuff")
                    }
                }
                cell { Text("Hello world this is a really long line that is going to wrap hopefully") }
            }
        }
    }
}