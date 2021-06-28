package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.skydoves.balloon.BalloonAnimation
import com.skydoves.balloon.createBalloon
import com.skydoves.orchestra.tooltips.BalloonAnchor
import com.steleot.jetpackcompose.playground.navigation.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold

private const val Url = "external/OrchestraBalloonScreen.kt"

@Composable
fun OrchestraBalloonScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.OrchestraBalloon,
        link = Url,
    ) {
        BalloonAnchorExample()
    }
}

@Composable
private fun BalloonAnchorExample() {
    ConstraintLayout(
        Modifier.fillMaxSize()
    ) {
        val (background, text) = createRefs()

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
            "Jetpack Compose Playground",
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
            balloon = createBalloon(LocalContext.current) {
                setText("Jetpack")
                setArrowPosition(0.7f)
                setCornerRadius(4f)
                setPadding(8)
                setBalloonAnimation(BalloonAnimation.FADE)
                setLifecycleOwner(LocalLifecycleOwner.current)
            },
            onAnchorClick = { balloon, anchor -> balloon.show(anchor) }
        )
    }
}
