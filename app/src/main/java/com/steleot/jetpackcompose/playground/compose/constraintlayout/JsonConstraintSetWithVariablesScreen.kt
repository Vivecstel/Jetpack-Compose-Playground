package com.steleot.jetpackcompose.playground.compose.constraintlayout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import org.intellij.lang.annotations.Language

private const val URL = "constraintlayout/JsonConstraintSetWithVariablesScreen.kt"

@Composable
fun JsonConstraintSetWithVariablesScreen() {
    DefaultScaffold(
        title = ConstraintLayoutNavRoutes.JsonConstraintSetWithVariables,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues = it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            JsonConstraintSetWithVariablesExample()
        }
    }
}

@Composable
private fun JsonConstraintSetWithVariablesExample() {
    @Language("json5") val constraintSet = """
          {
            Variables: {
              list: { from: 1, to: 12, prefix: 'h' },
              angle: { from: 0, step: 30 }
            },
            Generate: {
              list: { circular: ['parent', 'angle', 100] }
            },
            center: { center: 'parent' }
          } 
        """

    ConstraintLayout(
        ConstraintSet(constraintSet),
        modifier = Modifier.fillMaxSize()
    ) {
        Text(modifier = Modifier.layoutId("center"), text = "0")

        for (i in 0 until 12) {
            Text(
                modifier = Modifier.layoutId("h${i + 1}"),
                text = "${i + 1}"
            )
        }
    }
}