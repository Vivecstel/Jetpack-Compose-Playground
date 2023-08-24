package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.skydoves.balloon.BalloonAnimation
import com.skydoves.balloon.createBalloon
import com.skydoves.orchestra.tooltips.BalloonAnchor
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "externallibraries/OrchestraBalloonScreen.kt"

@Composable
fun OrchestraBalloonScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.OrchestraBalloon,
        link = URL,
    ) {
        BalloonAnchorExample(paddingValues = it)
    }
}

@Composable
private fun BalloonAnchorExample(paddingValues: PaddingValues) {
    ConstraintLayout(
        Modifier.fillMaxSize().padding(paddingValues = paddingValues)
    ) {
        val (background, text) = createRefs()
        val context = LocalContext.current

        Box(
            Modifier
                .size(200.dp)
                .constrainAs(background) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
                .background(MaterialTheme.colors.primary)
        )
        Text(
            stringResource(id = R.string.app_name),
            modifier = Modifier
                .constrainAs(text) {
                    top.linkTo(background.bottom)
                    bottom.linkTo(parent.bottom)
                }
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        BalloonAnchor(
            reference = background,
            balloon = createBalloon(context) {
                setTextResource(R.string.jetpack)
                setArrowPosition(0.7f)
                setCornerRadius(4f)
                setPadding(8)
                setBalloonAnimation(BalloonAnimation.FADE)
            },
            onAnchorClick = { balloon, anchor -> balloon.showAtCenter(anchor) },
        )
    }
}
