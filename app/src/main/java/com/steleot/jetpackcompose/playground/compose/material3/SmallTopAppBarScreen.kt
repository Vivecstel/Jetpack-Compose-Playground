package com.steleot.jetpackcompose.playground.compose.material3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.Material3NavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material3.DefaultScaffold

private const val URL = "material3/SmallTopAppBarScreen.kt"

@Composable
fun SmallTopAppBarScreen() {
    DefaultScaffold(
        title = Material3NavRoutes.SmallTopAppBar,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues = it),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DefaultSmallTopAppBar()
            ContainerColorSmallTopAppBar()
            NavigationIconSmallTopAppBar()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DefaultSmallTopAppBar() {
    SmallTopAppBar(
        title = {
            Text(text = stringResource(id = R.string.app_name))
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ContainerColorSmallTopAppBar() {
    SmallTopAppBar(
        title = {
            Text(text = stringResource(id = R.string.app_name))
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.tertiary
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun NavigationIconSmallTopAppBar() {
    SmallTopAppBar(
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
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    )
}
