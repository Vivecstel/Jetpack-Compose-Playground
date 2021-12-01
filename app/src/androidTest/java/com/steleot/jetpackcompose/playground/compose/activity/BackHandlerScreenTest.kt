package com.steleot.jetpackcompose.playground.compose.activity

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.steleot.jetpackcompose.playground.MainActivity
import com.steleot.jetpackcompose.playground.compose.theme.TestTheme
import org.junit.Rule
import org.junit.Test

class BackHandlerScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testBackHandlerScreen() {
        composeTestRule.setContent {
            TestTheme {
                BackHandlerScreen()
            }
        }
        // todo
    }
}