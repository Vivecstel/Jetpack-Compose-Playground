package com.steleot.jetpackcompose.playground.compose.material3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold3
import com.steleot.jetpackcompose.playground.navigation.Material3NavRoutes

private const val Url = "material3/LargeTopAppBarScreen.kt"

@Composable
fun LargeTopAppBarScreen() {
    DefaultScaffold3(
        title = Material3NavRoutes.LargeTopAppBar,
        link = Url,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DefaultLargeTopAppBar()
            ContainerColorLargeTopAppBar()
            NavigationIconLargeTopAppBar()
        }
    }
}

@Composable
private fun DefaultLargeTopAppBar() {
    LargeTopAppBar(
        title = {
            Text(text = stringResource(id = R.string.app_name))
        }
    )
}

@Composable
private fun ContainerColorLargeTopAppBar() {
    LargeTopAppBar(
        title = {
            Text(text = stringResource(id = R.string.app_name))
        },
        colors = TopAppBarDefaults.largeTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.tertiary
        )
    )
}

@Composable
private fun NavigationIconLargeTopAppBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(text = stringResource(id = R.string.app_name))
        },
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = stringResource(id = R.string.back_arrow),
                )
            }
        },
        colors = TopAppBarDefaults.largeTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    )
}