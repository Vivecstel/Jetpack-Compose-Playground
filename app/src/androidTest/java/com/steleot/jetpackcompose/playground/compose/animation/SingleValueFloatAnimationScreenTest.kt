package com.steleot.jetpackcompose.playground.compose.animation

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.steleot.jetpackcompose.playground.MainActivity
import com.steleot.jetpackcompose.playground.compose.theme.TestTheme
import org.junit.Rule
import org.junit.Test

class SingleValueFloatAnimationScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testSingleValueFloatAnimationScreen() {
        composeTestRule.setContent {
            TestTheme {
                SingleValueFloatAnimationScreen()
            }
        }
        // todo
    }
}