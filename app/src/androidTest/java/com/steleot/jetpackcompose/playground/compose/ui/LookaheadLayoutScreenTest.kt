package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.ui.test.junit4.createComposeRule
import com.steleot.jetpackcompose.playground.compose.theme.TestTheme
import org.junit.Rule
import org.junit.Test

class LookaheadLayoutScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testLocalWindowInfoScreen() {
        composeTestRule.setContent {
            TestTheme {
                LookaheadLayoutScreen()
            }
        }
        // todo
    }
}