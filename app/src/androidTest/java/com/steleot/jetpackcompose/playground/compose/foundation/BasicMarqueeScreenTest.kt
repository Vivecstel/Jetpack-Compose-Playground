package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.ui.test.junit4.createComposeRule
import com.steleot.jetpackcompose.playground.compose.theme.TestTheme
import org.junit.Rule
import org.junit.Test

class BasicMarqueeScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testBasicMarqueeScreen() {
        composeTestRule.setContent {
            TestTheme {
                BasicMarqueeScreen()
            }
        }
        // todo
    }
}