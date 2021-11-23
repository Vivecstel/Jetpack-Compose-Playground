package com.steleot.jetpackcompose.playground.compose.constraintlayout

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.steleot.jetpackcompose.playground.MainActivity
import com.steleot.jetpackcompose.playground.compose.theme.TestTheme
import org.junit.Rule
import org.junit.Test

class CreateGuidelineScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testCreateGuidelineScreen() {
        composeTestRule.setContent {
            TestTheme {
                CreateGuidelineScreen()
            }
        }
        // todo
    }
}