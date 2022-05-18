package com.steleot.jetpackcompose.playground.compose.material3

import androidx.compose.ui.test.junit4.createComposeRule
import com.steleot.jetpackcompose.playground.compose.theme.TestTheme3
import org.junit.Rule
import org.junit.Test

class RangeSlider3ScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testRangeSlider3Screen() {
        composeTestRule.setContent {
            TestTheme3 {
                RangeSlider3Screen()
            }
        }
        // todo
    }
}