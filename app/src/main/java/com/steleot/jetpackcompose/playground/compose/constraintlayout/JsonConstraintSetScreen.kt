package com.steleot.jetpackcompose.playground.compose.constraintlayout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.stringResource
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.ConstraintLayoutNavRoutes

private const val Url = "constraintlayout/JsonConstraintSetScreen.kt"

@Composable
fun JsonConstraintSetScreen() {
    DefaultScaffold(
        title = ConstraintLayoutNavRoutes.JsonConstraintSet,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            JsonConstraintSetExample()
        }
    }
}

@Composable
private fun JsonConstraintSetExample() {
    ConstraintLayout(
        ConstraintSet(
            """
            {
                Header: { exportAs: 'json contraint set example'},
                g1: { type: 'vGuideline', start: 80 },
                g2: { type: 'vGuideline', end: 80 },
                button1: {
                  width: 'spread',
                  top: ['title', 'bottom', 16],
                  start: ['g1', 'start'],
                  end: ['g2', 'end']
                },
                text1: {
                  width: { value: 'wrap', max: 300 },
                  centerVertically: 'parent',
                  start: ['g1', 'start'],
                  end: ['g2','end']
                }
            }
        """
        ),
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            modifier = Modifier.layoutId("button1"),
            onClick = {},
        ) {
            Text(text = stringResource(id = R.string.button_args, 1))
        }
        Text(
            modifier = Modifier
                .layoutId("text1")
                .background(Color.Red),
            text = stringResource(id = R.string.text_args, 1),
            style = MaterialTheme.typography.body1,
        )
    }
}