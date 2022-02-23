package com.steleot.jetpackcompose.playground.compose.constraintlayout

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.navigation.ConstraintLayoutNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val Url = "constraintlayout/MotionLayout2Screen.kt"

@Composable
fun MotionLayout2Screen() {
    DefaultScaffold(
        title = ConstraintLayoutNavRoutes.MotionLayout2,
        link = Url,
    ) {
        MotionLayout2Example()
    }
}

@OptIn(ExperimentalMotionApi::class)
@Composable
private fun MotionLayout2Example() {
    var animateToEnd by remember { mutableStateOf(false) }
    val progress by animateFloatAsState(
        targetValue = if (animateToEnd) 1f else 0f,
        animationSpec = tween(1000)
    )
    Column(Modifier.background(Color.White)) {
        MotionLayout(
            ConstraintSet(
                """ {
                background: {
                    custom: {
                      color: '#ffffff'
                    }
                },
                circle: {
                    start: ['parent', 'start', 0],
                    end: ['parent', 'end', 0],
                    top: ['parent','top',100],
                    custom: {
                      color: '#fcb045'
                    }
                },
                title: { 
                    width: "spread",
                    start: ['parent', 'start', 36],
                    top: ['circle', 'bottom', 16],
                    end: ['parent', 'end', 36],
                    custom: {
                      color: "#000000"
                    }
                },
                description: { 
                    width: "spread",
                    start: ['parent', 'start', 36],
                    top: ['title', 'bottom', 16],
                    end: ['parent', 'end', 36],
                    custom: {
                      color: "#ffffff"
                    }
                },
                backgroundSwitch: { 
                    start: ['parent', 'start', 36],
                    top: ['description', 'bottom', 16],
                    end: ['parent', 'end', 36],
                    custom: {
                      color: "#d2d2d2"
                    }
                },
                moonShadow: { 
                    top: ['circle', 'top', 4],
                    end: ['circle', 'end', 4],
                    alpha: 0.0
                },
                buttonSwitch: { 
                    top: ['backgroundSwitch', 'top', 0],
                    start: ['backgroundSwitch', 'start', 0]
                },
                light: { 
                    top: ['backgroundSwitch', 'top', 0],
                    start: ['backgroundSwitch', 'start', 0],
                    bottom: ['backgroundSwitch', 'bottom', 0]
                },
                dark: { 
                    top: ['backgroundSwitch', 'top', 0],
                    end: ['backgroundSwitch', 'end', 0],
                    bottom: ['backgroundSwitch', 'bottom', 0]
                }
             }"""
            ),
            ConstraintSet(
                """ {
                background: {
                    custom: {
                      color: '#000000'
                    }
                },
                circle: {
                    start: ['parent', 'start', 0],
                    end: ['parent', 'end', 0],
                    top: ['parent','top',100],
                    custom: {
                      color: '#7400ab'
                    }
                },
                    
                title: { 
                    width: "spread",
                    start: ['parent', 'start', 36],
                    top: ['circle', 'bottom', 16],
                    end: ['parent', 'end', 36],
                    custom: {
                      color: "#ffffff"
                    }
                },
                description: { 
                    width: "spread",
                    start: ['parent', 'start', 36],
                    top: ['title', 'bottom', 16],
                    end: ['parent', 'end', 36],
                    custom: {
                      color: "#000000"
                    }
                },
                backgroundSwitch: { 
                    start: ['parent', 'start', 36],
                    top: ['description', 'bottom', 16],
                    end: ['parent', 'end', 36],
                    custom: {
                      color: "#343434"
                    }
                },
                moonShadow: { 
                    top: ['circle', 'top', 4],
                    end: ['circle', 'end', 4],
                    alpha: 1.0
                },
                buttonSwitch: { 
                    top: ['backgroundSwitch', 'top', 0],
                    end: ['backgroundSwitch', 'end', 0]
                },
                light: { 
                    top: ['backgroundSwitch', 'top', 0],
                    start: ['backgroundSwitch', 'start', 0],
                    bottom: ['backgroundSwitch', 'bottom', 0]
                },
                dark: { 
                    top: ['backgroundSwitch', 'top', 0],
                    end: ['backgroundSwitch', 'end', 0],
                    bottom: ['backgroundSwitch', 'bottom', 0]
                }
              }"""
            ),
            progress = progress,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            Box(
                modifier = Modifier
                    .layoutId("background")
                    .fillMaxSize()
                    .clickable(onClick = { animateToEnd = !animateToEnd })
                    .background(motionProperties("background").value.color("color"))
            )

            Box(
                modifier = Modifier
                    .layoutId("circle")
                    .width(200.dp)
                    .height(200.dp)
                    .clip(CircleShape)
                    .background(motionProperties("circle").value.color("color"))
            )

            Text(
                text = stringResource(id = R.string.choose_style),
                modifier = Modifier.layoutId("title"),
                color = motionProperties("title").value.color("color"),
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )
            Text(
                text = stringResource(id = R.string.day_or_night),
                modifier = Modifier.layoutId("description"),
                color = motionProperties("title").value.color("color"),
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )
            Box(
                modifier = Modifier
                    .layoutId("backgroundSwitch")
                    .width(300.dp)
                    .height(72.dp)
                    .clip(RoundedCornerShape(36.dp))
                    .background(motionProperties("backgroundSwitch").value.color("color"))
            )

            Box(
                modifier = Modifier
                    .layoutId("moonShadow")
                    .width(170.dp)
                    .height(170.dp)
                    .clip(CircleShape)
                    .background(Color.Black)
            )

            Box(
                modifier = Modifier
                    .layoutId("buttonSwitch")
                    .width(150.dp)
                    .height(72.dp)
                    .clip(RoundedCornerShape(36.dp))
                    .background(Color.Gray)
            )

            Text(
                text = stringResource(id = R.string.light),
                modifier = Modifier
                    .layoutId("light")
                    .width(150.dp),
                color = Color.White,
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )
            Text(
                text = stringResource(id = R.string.dark),
                modifier = Modifier
                    .layoutId("dark")
                    .width(150.dp),
                color = Color.Black,
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}