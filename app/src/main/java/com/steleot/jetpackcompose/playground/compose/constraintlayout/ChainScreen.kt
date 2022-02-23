package com.steleot.jetpackcompose.playground.compose.constraintlayout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.navigation.ConstraintLayoutNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
import timber.log.Timber

private const val Url = "constraintlayout/ChainScreen.kt"

@Composable
fun ChainScreen() {
    DefaultScaffold(
        title = ConstraintLayoutNavRoutes.Chain,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ChainExample()
        }
    }
}

@Composable
private fun ChainExample() {
    ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
        val (button1, button2, button3) = createRefs()

        createHorizontalChain(button1, button2, button3, chainStyle = ChainStyle.Spread)
        Button(
            onClick = { Timber.d("Button 1 pressed") },
            modifier = Modifier.constrainAs(button1) {
            }
        ) {
            Text(stringResource(id = R.string.button_args, 1))
        }

        Button(
            onClick = { Timber.d("Button 2 pressed") },
            modifier = Modifier.constrainAs(button2) {
            }
        ) {
            Text(stringResource(id = R.string.button_args, 2))
        }

        Button(
            onClick = { Timber.d("Button 3 pressed") },
            modifier = Modifier.constrainAs(button3) {

            }
        ) {
            Text(stringResource(id = R.string.button_args, 3))
        }

    }
}
