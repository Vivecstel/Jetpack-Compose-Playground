package com.steleot.jetpackcompose.playground.compose.constraintlayout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Button
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.steleot.jetpackcompose.playground.navigation.graph.ConstraintLayoutNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "constraintlayout/ConstraintHorizontalFlowScreen.kt"

@Composable
fun ConstraintHorizontalFlowScreen() {
    DefaultScaffold(
        title = ConstraintLayoutNavRoutes.ConstraintHorizontalFlow,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ConstraintHorizontalFlowExample()
        }
    }
}

@Composable
private fun ConstraintHorizontalFlowExample() {
    ConstraintLayout(
        ConstraintSet(
            """
            {
                flow1: {
                    width: 'parent',
                    height: 'parent',
                    type: 'hFlow',
                    wrap: 'chain',
                    maxElement: 3,
                    contains: ['1', '2', '3', '4', '5']
                }
            }
        """
        ),
        modifier = Modifier.fillMaxSize()
    ) {
        val numArray = arrayOf("1", "2", "3", "4", "5")
        for (num in numArray) {
            Button(
                modifier = Modifier.layoutId(num),
                onClick = { /* empty implementation */ }
            ) {
                Text(text = num)
            }
        }
    }
}
