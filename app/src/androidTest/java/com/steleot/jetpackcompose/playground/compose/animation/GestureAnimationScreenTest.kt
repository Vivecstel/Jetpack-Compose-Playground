package com.steleot.jetpackcompose.playground.compose.animation

import androidx.compose.ui.test.junit4.createComposeRule
import com.steleot.jetpackcompose.playground.compose.theme.TestTheme
import org.junit.Rule
import org.junit.Test

class GestureAnimationScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testGestureAnimationScreen() {
        composeTestRule.setContent {
            TestTheme {
                GestureAnimationScreen()
            }
        }
        // todo
    }
}