package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.ui.test.junit4.createComposeRule
import com.steleot.jetpackcompose.playground.compose.theme.TestTheme
import org.junit.Rule
import org.junit.Test

class TextIndentScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testTextIndentScreen() {
        composeTestRule.setContent {
            TestTheme {
                TextIndentScreen()
            }
        }
        // todo
    }
}