package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.steleot.jetpackcompose.playground.MainActivity
import com.steleot.jetpackcompose.playground.compose.theme.TestTheme
import org.junit.Rule
import org.junit.Test

class ButtonScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testButtonScreen() {
        composeTestRule.setContent {
            TestTheme {
                ButtonScreen()
            }
        }

        composeTestRule
            .onNodeWithText("Default Button")
            .assertIsDisplayed()
            .performClick()

        composeTestRule
            .onNodeWithText("Cut Corner Shape Button")
            .assertIsDisplayed()
            .performClick()

        composeTestRule
            .onNodeWithText("Rounded Corner Shape Button")
            .assertIsDisplayed()
            .performClick()

        composeTestRule
            .onNodeWithText("Background Color Button")
            .assertIsDisplayed()
            .performClick()

        composeTestRule
            .onNodeWithText("Fake Button")
            .assertDoesNotExist()
    }
}