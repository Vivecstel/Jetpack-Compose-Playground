package com.steleot.jetpackcompose.playground.compose.material3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold3
import com.steleot.jetpackcompose.playground.navigation.Material3NavRoutes

private const val Url = "material3/SmallTopAppBarScreen.kt"

@Composable
fun SmallTopAppBarScreen() {
    DefaultScaffold3(
        title = Material3NavRoutes.SmallTopAppBar,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DefaultSmallTopAppBar()
            ContainerColorSmallTopAppBar()
            NavigationIconSmallTopAppBar()
        }
    }
}

@Composable
private fun DefaultSmallTopAppBar() {
    SmallTopAppBar(
        title = {
            Text(text = stringResource(id = R.string.app_name))
        }
    )
}

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
