package com.steleot.jetpackcompose.playground.compose.constraintlayout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.navigation.ConstraintLayoutNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
import timber.log.Timber

private const val Url = "constraintlayout/CreateRefsScreen.kt"

@Composable
fun CreateRefsScreen() {
    DefaultScaffold(
        title = ConstraintLayoutNavRoutes.CreateRefs,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CreateRefsExample()
        }
    }
}

@Composable
private fun CreateRefsExample() {
    ConstraintLayout(
        modifier = Modifier.padding(32.dp)
    ) {
        val (button1, text1, text2, button2) = createRefs()
        Button(
            onClick = { Timber.d("Button 1 pressed") },
            modifier = Modifier.constrainAs(button1) {
                top.linkTo(parent.top, margin = 32.dp)
            }
        ) {
            Text(stringResource(id = R.string.button_args, 1))
        }
        Text(stringResource(id = R.string.text_args, 1), Modifier.constrainAs(text1) {
            top.linkTo(button1.bottom, margin = 16.dp)
        })
        Text(stringResource(id = R.string.text_args, 2), Modifier.constrainAs(text2) {
            start.linkTo(text1.end, margin = 32.dp)
            top.linkTo(button1.bottom, margin = 16.dp)
        })
        Button(
            onClick = { Timber.d("Button 2 pressed") },
            modifier = Modifier.constrainAs(button2) {
                start.linkTo(text1.end, margin = 32.dp)
                top.linkTo(text2.top, margin = 32.dp)
            }
        ) {
            Text(stringResource(id = R.string.button_args, 2))
        }
    }
}