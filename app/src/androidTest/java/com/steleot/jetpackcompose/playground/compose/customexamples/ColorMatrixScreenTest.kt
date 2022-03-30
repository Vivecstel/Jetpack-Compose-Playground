package com.steleot.jetpackcompose.playground.compose.customexamples

import androidx.compose.ui.test.junit4.createComposeRule
import com.steleot.jetpackcompose.playground.compose.theme.TestTheme
import org.junit.Rule
import org.junit.Test

class ColorMatrixScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testColorMatrixScreen() {
        composeTestRule.setContent {
            TestTheme {
                ColorMatrixScreen()
            }
        }
        // todo
    }
}