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
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import com.steleot.jetpackcompose.playground.ConstraintLayoutNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.Locale
import timber.log.Timber

private const val Url = "constraintlayout/ChainScreen.kt"

@Composable
fun ChainScreen() {
    DefaultScaffold(
        title = ConstraintLayoutNavRoutes.Chain.capitalize(Locale.getDefault()),
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
            Text("Button 1")
        }

        Button(
            onClick = { Timber.d("Button 2 pressed") },
            modifier = Modifier.constrainAs(button2) {
            }
        ) {
            Text("Button 2")
        }

        Button(
            onClick = { Timber.d("Button 3 pressed") },
            modifier = Modifier.constrainAs(button3) {

            }
        ) {
            Text("Button 3")
        }

    }
}
