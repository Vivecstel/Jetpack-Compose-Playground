package com.steleot.jetpackcompose.playground.compose.reusable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.steleot.jetpackcompose.playground.R

@Composable
fun DefaultListItem(
    text: String,
    modifier: Modifier,
    navController: NavHostController,
) {
    Card(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
            .clickable(onClick = { navController.navigate(text) })
    ) {
        Text(
            text,
            style = MaterialTheme.typography.body1,
            modifier = modifier
                .padding(16.dp)
        )
    }
}

@Composable
fun DefaultTopAppBar(
    navController: NavHostController,
    showBackArrow: Boolean
) {
    TopAppBar(
        title = {
            Text(text = stringResource(id = R.string.app_name))
        },
        navigationIcon = {
            if (showBackArrow) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
                }
            }
        }
    )
}
