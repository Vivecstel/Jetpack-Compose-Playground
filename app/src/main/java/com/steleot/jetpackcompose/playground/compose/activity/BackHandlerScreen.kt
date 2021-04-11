package com.steleot.jetpackcompose.playground.compose.activity

import androidx.activity.compose.BackHandler
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.steleot.jetpackcompose.playground.ActivityNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold

private const val Url = "activity/BackHandlerScreen.kt"

@Composable
fun BackHandlerScreen(navController: NavHostController) {
    DefaultScaffold(
        title = ActivityNavRoutes.BackHandler,
        link = Url,
    ) {
        BackHandlerExample(navController)
    }
}

@Composable
private fun BackHandlerExample(navController: NavHostController) {
    var backPressedCount by remember { mutableStateOf(0) }
    BackHandler {
        if (backPressedCount >= 5) {
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
            Text("Press Back count $backPressedCount")
        }
        Text(text = "Press more than 5 times to exit.")
    }

}