package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.steleot.jetpackcompose.playground.MainActivity
import com.steleot.jetpackcompose.playground.compose.theme.TestTheme
import org.junit.Rule
import org.junit.Test

class LocalOverScrollConfigurationScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testLocalOverScrollConfigurationScreen() {
        composeTestRule.setContent {
            TestTheme {
                LocalOverScrollConfigurationScreen()
            }
        }
        // todo
    }
}