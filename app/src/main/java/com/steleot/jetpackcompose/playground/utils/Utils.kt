package com.steleot.jetpackcompose.playground.utils

internal fun randomSampleImageUrl(
    seed: Int = (0..100000).random(),
    width: Int = 300,
    height: Int = width,
): String = "https://picsum.photos/seed/$seed/$width/$height"