package com.steleot.jetpackcompose.playground.compose.rest

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultTopAppBar
import com.steleot.jetpackcompose.playground.compose.reusable.ErrorText
import com.steleot.jetpackcompose.playground.compose.reusable.ribbonRoutes
import com.steleot.jetpackcompose.playground.navigation.MainNavRoutes

val newRoutes = ribbonRoutes.filter {
    it !in routes
}.sorted().toList()

@Composable
fun NewScreen() {

    DefaultScaffold(
        topBar = {
            DefaultTopAppBar(
                title = MainNavRoutes.New,
            )
        }
    ) {
        if (newRoutes.isNotEmpty()) {
            MainScreenContent(it, newRoutes)
        } else {
            Box(modifier = Modifier.fillMaxSize()) {
                ErrorText(text = stringResource(id = R.string.new_empty))
            }
        }
    }
}