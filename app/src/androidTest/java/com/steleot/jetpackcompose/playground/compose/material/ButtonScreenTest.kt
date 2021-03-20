package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.google.accompanist.insets.ProvideWindowInsets
import com.steleot.jetpackcompose.playground.theme.PlaygroundTheme
import org.junit.Rule
import org.junit.Test

class ButtonScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun TestButtonScreen() {
        composeTestRule.setContent {
            PlaygroundTheme {
                ProvideWindowInsets {
                    ButtonScreen()
                }
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