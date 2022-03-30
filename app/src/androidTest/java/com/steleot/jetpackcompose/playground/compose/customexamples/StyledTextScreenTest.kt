package com.steleot.jetpackcompose.playground.compose.customexamples

import androidx.compose.ui.test.junit4.createComposeRule
import com.steleot.jetpackcompose.playground.compose.theme.TestTheme
import org.junit.Rule
import org.junit.Test

class StyledTextScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testStyledTextScreen() {
        composeTestRule.setContent {
            TestTheme {
                StyledTextScreen()
            }
        }
        // todo
    }
}