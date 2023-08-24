package com.steleot.jetpackcompose.playground.compose.constraintlayout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Button
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.steleot.jetpackcompose.playground.navigation.graph.ConstraintLayoutNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "constraintlayout/ConstraintGridDslScreen.kt"

@Composable
fun ConstraintGridDslScreen() {
    DefaultScaffold(
        title = ConstraintLayoutNavRoutes.ConstraintGridDsl,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues = it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ConstraintGridDslExample()
        }
    }
}

@Composable
private fun ConstraintGridDslExample() {
    val numArray = arrayOf("1", "2", "3", "4", "5")
    ConstraintLayout(
        constraintSet = ConstraintSet {
            val elem =
                Array(numArray.size) { i -> createRefFor(String.format("btn_%s", numArray[i])) }
            val g1 = createRow(
                elements = elem,
                horizontalGap = 10.dp,
            )
            constrain(g1) {
                width = Dimension.matchParent
                height = Dimension.matchParent
                top.linkTo(parent.top, 20.dp)
                bottom.linkTo(parent.bottom, 20.dp)
                start.linkTo(parent.start, 20.dp)
                end.linkTo(parent.end, 20.dp)
            }
        },
        modifier = Modifier.fillMaxSize()
    ) {
        for (num in numArray) {
            Button(
                modifier = Modifier.layoutId(String.format("btn_%s", num)),
                onClick = { /* empty implementation */ }
            ) {
                Text(text = num, fontSize = 30.sp)
            }
        }
    }
}
