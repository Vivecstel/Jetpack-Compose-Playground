package com.steleot.jetpackcompose.playground.compose.activity

import androidx.activity.compose.BackHandler
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Button
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.localproviders.LocalNavController
import com.steleot.jetpackcompose.playground.navigation.graph.ActivityNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "activity/BackHandlerScreen.kt"

@Composable
fun BackHandlerScreen() {
    val navController = LocalNavController.current
    DefaultScaffold(
        title = ActivityNavRoutes.BackHandler,
        link = URL,
    ) {
        BackHandlerExample(navController)
    }
}

private const val MAX_PRESSED = 4

@Composable
private fun BackHandlerExample(navController: NavHostController) {
    var backPressedCount by rememberSaveable { mutableIntStateOf(0) }
    BackHandler {
        if (backPressedCount >= MAX_PRESSED) {
            navController.popBackStack()
        } else {
            backPressedCount++
        }
    }

    val dispatcher = LocalOnBackPressedDispatcherOwner.current!!.onBackPressedDispatcher

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { dispatcher.onBackPressed() }) {
            Text(stringResource(id = R.string.back_handler_count, backPressedCount))
        }
        Text(text = stringResource(id = R.string.back_handler_msg, MAX_PRESSED))
    }

}