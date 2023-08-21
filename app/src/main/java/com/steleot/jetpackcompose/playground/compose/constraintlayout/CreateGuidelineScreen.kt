package com.steleot.jetpackcompose.playground.compose.constraintlayout

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Button
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.ConstraintLayoutNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
import timber.log.Timber

private const val URL = "constraintlayout/CreateGuidelineScreen.kt"

@Composable
fun CreateGuidelineScreen() {
    DefaultScaffold(
        title = ConstraintLayoutNavRoutes.CreateGuideline,
        link = URL,
    ) {
        CreateGuidelineExample(paddingValues = it)
    }
}

@Composable
private fun CreateGuidelineExample(paddingValues: PaddingValues) {
    ConstraintLayout(Modifier.fillMaxSize().padding(paddingValues = paddingValues)) {
        val b1 = createRef()
        val g1 = createGuidelineFromTop(75.dp)
        val g2 = createGuidelineFromBottom(75.dp)
        val g3 = createGuidelineFromStart(75.dp)
        val g4 = createGuidelineFromEnd(75.dp)
        Button(
            modifier = Modifier.constrainAs(b1) {
                top.linkTo(g1)
                bottom.linkTo(g2)
                start.linkTo(g3)
                end.linkTo(g4)
                height = Dimension.fillToConstraints
            },
            onClick = { Timber.d("Button pressed") },
        ) {
            Text(text = stringResource(id = R.string.app_name))
        }
    }
}