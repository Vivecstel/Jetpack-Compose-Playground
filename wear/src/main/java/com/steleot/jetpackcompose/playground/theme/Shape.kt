package com.steleot.jetpackcompose.playground.theme

import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Shapes

val shapes = Shapes(
    small = RoundedCornerShape(corner = CornerSize(50)),
    medium = RoundedCornerShape(8.dp),
    large = RoundedCornerShape(20.dp)
)