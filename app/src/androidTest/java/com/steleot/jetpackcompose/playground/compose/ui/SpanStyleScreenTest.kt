package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.steleot.jetpackcompose.playground.MainActivity
import com.steleot.jetpackcompose.playground.compose.theme.TestTheme
import org.junit.Rule
import org.junit.Test

class SpanStyleScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testSpanStyleScreen() {
        composeTestRule.setContent {
            TestTheme {
                SpanStyleScreen()
            }
        }
        // todo
    }
}