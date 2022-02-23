package com.steleot.jetpackcompose.playground.compose.constraintlayout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.navigation.ConstraintLayoutNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
import timber.log.Timber

private const val Url = "constraintlayout/ConstraintSetScreen.kt"

@Composable
fun ConstraintSetScreen() {
    DefaultScaffold(
        title = ConstraintLayoutNavRoutes.ConstraintSet,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ConstraintSetExample()
        }
    }
}

@Composable
private fun ConstraintSetExample() {
    BoxWithConstraints {
        val constraints = if (maxWidth < maxHeight) {
            decoupledConstraints(margin = 16.dp) // Portrait constraints
        } else {
            decoupledConstraints(margin = 32.dp) // Landscape constraints
        }

        ConstraintLayout(constraints) {
            Button(
                onClick = { Timber.d("Button 1 pressed") },
                modifier = Modifier.layoutId("button1")
            ) {
                Text(stringResource(id = R.string.button_args, 1))
            }

            Text(stringResource(id = R.string.text_args, 1), Modifier.layoutId("text1"))
        }
    }
}

private fun decoupledConstraints(margin: Dp): ConstraintSet {
    return ConstraintSet {
        val button = createRefFor("button1")
        val text = createRefFor("text1")

        constrain(button) {
            top.linkTo(parent.top, margin = margin)
        }
        constrain(text) {
            top.linkTo(button.bottom, margin)
        }
    }
}
