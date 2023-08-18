package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.ui.test.junit4.createComposeRule
import com.steleot.jetpackcompose.playground.compose.theme.TestTheme
import org.junit.Rule
import org.junit.Test

class BasicTextFieldScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testBasicTextFieldScreen() {
        composeTestRule.setContent {
            TestTheme {
                BasicTextFieldScreen()
            }
        }
        // todo
    }
}