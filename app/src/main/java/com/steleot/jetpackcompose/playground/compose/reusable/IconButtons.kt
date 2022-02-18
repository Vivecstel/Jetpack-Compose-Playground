package com.steleot.jetpackcompose.playground.compose.reusable

import android.content.Intent
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.core.net.toUri
import com.steleot.jetpackcompose.playground.BuildConfig
import com.steleot.jetpackcompose.playground.R
import androidx.compose.material3.Icon as Icon3
import androidx.compose.material3.IconButton as IconButton3

@Composable
fun GoToGithubIconButton(link: String) {
    val context = LocalContext.current
    IconButton(onClick = {
        context.startActivity(Intent(Intent.ACTION_VIEW).apply {
            data = "${BuildConfig.BASE_URL}$link".toUri()
        })
    }) {
        Icon(
            imageVector = Icons.Filled.ExitToApp,
            contentDescription = stringResource(id = R.string.open_github),
        )
    }
}

@Composable
fun BackArrowIconButton() {
    val backDispatcher = LocalOnBackPressedDispatcherOwner.current
    IconButton(onClick = {
        backDispatcher?.onBackPressedDispatcher?.onBackPressed()
    }) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = stringResource(id = R.string.back_arrow),
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
        )
    }
}

@Composable
fun OpenDrawerIconButton(
    onClick: () -> Unit
) {
    IconButton(onClick = onClick) {
        Icon(
            Icons.Filled.Menu, contentDescription = stringResource(id = R.string.open_drawer)
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
            contentDescription = null
        )
    }
}

@Composable
fun GoToGithubButton3(link: String) {
    val context = LocalContext.current
    IconButton3(onClick = {
        context.startActivity(Intent(Intent.ACTION_VIEW).apply {
            data = "${BuildConfig.BASE_URL}$link".toUri()
        })
    }) {
        Icon3(
            imageVector = Icons.Filled.ExitToApp,
            contentDescription = stringResource(id = R.string.open_github),
        )
    }
}

@Composable
fun BackArrow3() {
    val backDispatcher = LocalOnBackPressedDispatcherOwner.current
    IconButton3(onClick = {
        backDispatcher?.onBackPressedDispatcher?.onBackPressed()
    }) {
        Icon3(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = stringResource(id = R.string.back_arrow),
        )
    }
}

@Composable
fun SearchIconButton3(
    onClick: () -> Unit
) {
    IconButton3(onClick = onClick) {
        Icon3(
            imageVector = Icons.Filled.Search,
            contentDescription = stringResource(id = R.string.search),
        )
    }
}

@Composable
fun DropdownIconButton3(
    onClick: () -> Unit
) {
    IconButton3(onClick = onClick) {
        Icon3(
            Icons.Filled.MoreVert,
            contentDescription = null
        )
    }
}