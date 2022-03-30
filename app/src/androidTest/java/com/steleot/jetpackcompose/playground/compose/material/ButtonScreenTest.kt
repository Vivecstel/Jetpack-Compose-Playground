package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.steleot.jetpackcompose.playground.compose.theme.TestTheme
import org.junit.Rule
import org.junit.Test

class ButtonScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testButtonScreen() {
        composeTestRule.setContent {
            TestTheme {
                ButtonScreen()
            }
        }

        composeTestRule
            .onNodeWithTag("Default Button")
            .assertIsDisplayed()
            .performClick()

        composeTestRule
            .onNodeWithTag("Cut Corner Shape Button")
            .assertIsDisplayed()
            .performClick()

        composeTestRule
            .onNodeWithTag("Rounded Corner Shape Button")
            .assertIsDisplayed()
            .performClick()

        composeTestRule
            .onNodeWithTag("Background Color Button")
            .assertIsDisplayed()
            .performClick()

        composeTestRule
            .onNodeWithTag("Fake Button")
            .assertDoesNotExist()
    }
}