package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.FoundationNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
import com.steleot.jetpackcompose.playground.utils.shortToast

private const val URL = "foundation/CombinedClickableScreen.kt"

@Composable
fun CombinedClickableScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.CombinedClickable,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues = it),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CombinedClickableExample()
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CombinedClickableExample() {
    val context = LocalContext.current
    Text(
        text = "Combined Clickable Text",
        modifier = Modifier
            .combinedClickable(
                onDoubleClick = {
                    context.shortToast(R.string.double_click)
                }, onClick = {
                    context.shortToast(R.string.single_click)
                }, onLongClick = {
                    context.shortToast(R.string.long_click)
                })
            .border(BorderStroke(2.dp, MaterialTheme.colors.primary))
            .padding(32.dp)
    )
}
