package com.steleot.jetpackcompose.playground.compose.constraintlayout

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.steleot.jetpackcompose.playground.MainActivity
import com.steleot.jetpackcompose.playground.compose.theme.TestTheme
import org.junit.Rule
import org.junit.Test

class MotionLayout2ScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testMotionLayout2Screen() {
        composeTestRule.setContent {
            TestTheme {
                MotionLayout2Screen()
            }
        }
        // todo
    }
}