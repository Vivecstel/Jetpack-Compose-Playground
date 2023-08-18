package com.steleot.jetpackcompose.playground.ui.base.material

import android.content.Intent
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Icon
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.core.net.toUri
import com.steleot.jetpackcompose.playground.BuildConfig
import com.steleot.jetpackcompose.playground.resources.R

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

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun BackArrowIconButton() {
    val backDispatcher = LocalOnBackPressedDispatcherOwner.current
    val keyboardController = LocalSoftwareKeyboardController.current

    IconButton(onClick = {
        backDispatcher?.onBackPressedDispatcher?.onBackPressed()
        keyboardController?.hide()
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