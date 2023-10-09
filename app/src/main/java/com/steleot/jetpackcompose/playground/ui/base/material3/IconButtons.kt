package com.steleot.jetpackcompose.playground.ui.base.material3

import android.content.Intent
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.core.net.toUri
import com.steleot.jetpackcompose.playground.BuildConfig
import com.steleot.jetpackcompose.playground.resources.R

// todo stelios remove tint when localcontentcolor is propagated correctly from topappbar correctly
@Composable
fun GoToGithubButton(link: String) {
    val context = LocalContext.current
    IconButton(onClick = {
        context.startActivity(Intent(Intent.ACTION_VIEW).apply {
            data = "${BuildConfig.BASE_URL}$link".toUri()
        })
    }) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ExitToApp,
            contentDescription = stringResource(id = R.string.open_github),
            tint = MaterialTheme.colorScheme.onPrimary
        )
    }
}

@Composable
fun BackArrow() {
    val backDispatcher = LocalOnBackPressedDispatcherOwner.current
    IconButton(onClick = {
        backDispatcher?.onBackPressedDispatcher?.onBackPressed()
    }) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = stringResource(id = R.string.back_arrow),
            tint = MaterialTheme.colorScheme.onPrimary
        )
    }
}

@Composable
fun SearchIconButton(
    onClick: () -> Unit
) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = stringResource(id = R.string.search),
            tint = MaterialTheme.colorScheme.onPrimary
        )
    }
}

@Composable
fun DropdownIconButton(
    onClick: () -> Unit
) {
    IconButton(onClick = onClick) {
        Icon(
            Icons.Filled.MoreVert,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onPrimary
        )
    }
}