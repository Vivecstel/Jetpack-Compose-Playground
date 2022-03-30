package com.steleot.jetpackcompose.playground.compose.animation

import androidx.compose.ui.test.junit4.createComposeRule
import com.steleot.jetpackcompose.playground.compose.theme.TestTheme
import org.junit.Rule
import org.junit.Test

class RotateAnimationScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testRotateAnimationScreen() {
        composeTestRule.setContent {
            TestTheme {
                RotateAnimationScreen()
            }
        }
        // todo
    }
}