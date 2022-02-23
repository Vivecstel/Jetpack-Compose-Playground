package com.steleot.jetpackcompose.playground.ui.base.material

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.google.accompanist.insets.systemBarsPadding

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
//    val inAppReviewer = LocalInAppReviewer.current
    Scaffold(
        modifier = Modifier.systemBarsPadding(),
        topBar = topBar,
        content = content,
    )
    // todo stelios
//    LaunchedEffect(Unit) {
//        if (context is Activity) inAppReviewer.requestReview(context)
//    }
}