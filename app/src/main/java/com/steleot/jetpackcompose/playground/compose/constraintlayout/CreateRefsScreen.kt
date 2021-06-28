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
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.steleot.jetpackcompose.playground.navigation.ConstraintLayoutNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold

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
            onClick = { },
            modifier = Modifier.constrainAs(button1) {
                top.linkTo(parent.top, margin = 32.dp)
            }
        ) {
            Text("Button 1")
        }
        Text("Jetpack text1", Modifier.constrainAs(text1) {
            top.linkTo(button1.bottom, margin = 16.dp)
        })
        Text("Jetpack text2", Modifier.constrainAs(text2) {
            start.linkTo(text1.end, margin = 32.dp)
            top.linkTo(button1.bottom, margin = 16.dp)
        })
        Button(
            onClick = { },
            modifier = Modifier.constrainAs(button2) {
                start.linkTo(text1.end, margin = 32.dp)
                top.linkTo(text2.top, margin = 32.dp)
            }
        ) {
            Text("Button 2")
        }
    }
}