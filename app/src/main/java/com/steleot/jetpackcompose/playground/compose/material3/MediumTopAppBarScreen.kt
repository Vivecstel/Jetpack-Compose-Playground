package com.steleot.jetpackcompose.playground.compose.material3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.navigation.Material3NavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material3.DefaultScaffold

private const val Url = "material3/MediumTopAppBarScreen.kt"

@Composable
fun MediumTopAppBarScreen() {
    DefaultScaffold(
        title = Material3NavRoutes.MediumTopAppBar,
        link = Url,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DefaultMediumTopAppBar()
            ContainerColorMediumTopAppBar()
            NavigationIconMediumTopAppBar()
        }
    }
}

@Composable
private fun DefaultMediumTopAppBar() {
    MediumTopAppBar(
        title = {
            Text(text = stringResource(id = R.string.app_name))
        }
    )
}

@Composable
private fun ContainerColorMediumTopAppBar() {
    MediumTopAppBar(
        title = {
            Text(text = stringResource(id = R.string.app_name))
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.tertiary
        )
    )
}

@Composable
private fun NavigationIconMediumTopAppBar() {
    MediumTopAppBar(
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
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    )
}