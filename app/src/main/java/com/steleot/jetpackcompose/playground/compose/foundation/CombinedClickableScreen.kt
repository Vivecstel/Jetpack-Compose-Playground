package com.steleot.jetpackcompose.playground.compose.foundation

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.FoundationNavRoutes

private const val Url = "foundation/CombinedClickableScreen.kt"

@Composable
fun CombinedClickableScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.CombinedClickable,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
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
                    toast(context, R.string.double_click)
                }, onClick = {
                    toast(context, R.string.single_click)
                }, onLongClick = {
                    toast(context, R.string.long_click)
                })
            .border(BorderStroke(2.dp, MaterialTheme.colors.primary))
            .padding(32.dp)

    )
}

private fun toast(
    context: Context,
    @StringRes messageRes: Int,
) {
    Toast.makeText(context, messageRes, Toast.LENGTH_SHORT).show()
}