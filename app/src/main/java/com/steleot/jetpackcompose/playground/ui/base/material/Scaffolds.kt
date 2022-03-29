package com.steleot.jetpackcompose.playground.ui.base.material

import android.app.Activity
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.steleot.jetpackcompose.playground.localproviders.LocalInAppReviewer

@Composable
fun DefaultScaffold(
    title: String,
    link: String? = null,
    content: @Composable (PaddingValues) -> Unit,
) {
    DefaultScaffold(
        topBar = {
            DefaultTopAppBar(
                title = title,
                link = link,
            )
        },
        content = content
    )
}

@Composable
fun DefaultScaffold(
    topBar: @Composable () -> Unit = {},
    content: @Composable (PaddingValues) -> Unit,
) {
    val context = LocalContext.current
    val inAppReviewer = LocalInAppReviewer.current
    Scaffold(
        modifier = Modifier.systemBarsPadding(),
        topBar = topBar,
        content = content,
    )
    LaunchedEffect(Unit) {
        if (context is Activity) inAppReviewer.requestReview(context)
    }
}