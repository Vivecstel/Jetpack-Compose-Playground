package com.steleot.jetpackcompose.playground.compose.customexamples

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.steleot.jetpackcompose.playground.MainActivity
import com.steleot.jetpackcompose.playground.compose.theme.TestTheme
import org.junit.Rule
import org.junit.Test

class MessageBubbleScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testMessageBubbleScreen() {
        composeTestRule.setContent {
            TestTheme {
                MessageBubbleScreen()
            }
        }
        // todo
    }
}