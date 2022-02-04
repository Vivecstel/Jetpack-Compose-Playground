package com.steleot.jetpackcompose.playground.compose.constraintlayout

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.MotionScene
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.ConstraintLayoutNavRoutes

private const val Url = "constraintlayout/MotionLayout3Screen.kt"

@Composable
fun MotionLayout3Screen() {
    DefaultScaffold(
        title = ConstraintLayoutNavRoutes.MotionLayout3,
        link = Url,
    ) {
        MotionLayout3Example()
    }
}

@OptIn(ExperimentalMotionApi::class)
@Composable
private fun MotionLayout3Example() {
    var animateToEnd by remember { mutableStateOf(false) }

    val progress by animateFloatAsState(
        targetValue = if (animateToEnd) 1f else 0f,
        animationSpec = tween(1000)
    )
    Column {
        MotionLayout(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color.White),
            motionScene = MotionScene(
                """{
  ConstraintSets: {
    start: {
      backgroundSwipe: {
        start: ['parent', 'start', 2],
        end: ['parent','end',2],
        top: ['parent','top',2],
        bottom: ['parent','bottom',2]
      },
      backgroundButtonSwipe: {
        width: "spread",
        height: "spread",
        start: ['buttonSwipe', 'start', 0],
        end: ['buttonSwipe','end',0],
        top: ['buttonSwipe','top',0],
        bottom: ['backgroundSwipe','bottom',0]
      },
      swipeUp: {
        start: ['buttonSwipe', 'start', 0],
        end: ['buttonSwipe','end',0],
        top: ['buttonSwipe','top',0],
        bottom: ['buttonSwipe','bottom',0]
      },
      buttonSwipe: {
        start: ['backgroundSwipe', 'start', 0],
        end: ['backgroundSwipe','end',0],
        bottom: ['backgroundSwipe','bottom',0],
        custom: {
          color: "#004DBC"
        }
      }
    },
    end: {
      Extends: 'start',
      buttonSwipe: {
        clear: ['constraints'],
        start: ['backgroundSwipe', 'start', 0],
        end: ['backgroundSwipe','end',0],
        top: ['backgroundSwipe','top',2],
        custom: {
          color: "#33D6C1"
        }
      }
    }
  }
}
"""
            ),
            progress = progress
        ) {
            Box(
                modifier = Modifier
                    .layoutId("backgroundSwipe")
                    .height(450.dp)
                    .width(80.dp)
                    .clip(shape = RoundedCornerShape(40.dp))
                    .background(Color.LightGray)
                    .border(2.dp, Color.DarkGray, shape = RoundedCornerShape(40.dp))

            )

            Box(
                modifier = Modifier
                    .layoutId("backgroundButtonSwipe")
                    .width(80.dp)
                    .clip(shape = RoundedCornerShape(40.dp))
                    .background(Color(0xFF4462D7.toInt()))
                    .border(2.dp, Color.DarkGray, shape = RoundedCornerShape(40.dp))
            )

            Box(
                modifier = Modifier
                    .layoutId("buttonSwipe")
                    .height(78.dp)
                    .width(78.dp)
                    .clip(shape = CircleShape)
                    .background(motionProperties("buttonSwipe").value.color("color"))
                    .clickable(onClick = { animateToEnd = !animateToEnd })

            )
            Icon(
                Icons.Sharp.KeyboardArrowUp,
                contentDescription = stringResource(id = R.string.swipe_up),
                tint = Color.White,
                modifier = Modifier
                    .layoutId("swipeUp")
                    .width(40.dp)
                    .height(40.dp)
            )
        }
    }
}