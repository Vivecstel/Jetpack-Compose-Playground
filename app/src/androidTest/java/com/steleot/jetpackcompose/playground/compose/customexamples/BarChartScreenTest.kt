package com.steleot.jetpackcompose.playground.compose.customexamples

import androidx.compose.ui.test.junit4.createComposeRule
import com.steleot.jetpackcompose.playground.compose.theme.TestTheme
import org.junit.Rule
import org.junit.Test

class BarChartScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testBarChartScreen() {
        composeTestRule.setContent {
            TestTheme {
                BarChartScreen()
            }
        }
        // todo
    }
}