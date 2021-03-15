package com.steleot.jetpackcompose.playground.compose.constraintlayout

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.steleot.jetpackcompose.playground.MainNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.Locale

private const val Url = "constraintlayout/ConstraintLayoutScreen.kt"

@Composable
fun ConstraintLayoutScreen() {
    DefaultScaffold(
        title = MainNavRoutes.ConstraintLayout.capitalize(Locale.getDefault()),
        link = Url,
    ) {
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
}