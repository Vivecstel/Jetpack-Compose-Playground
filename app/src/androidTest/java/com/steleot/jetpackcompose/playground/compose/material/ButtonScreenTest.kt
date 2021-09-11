package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.google.accompanist.insets.ProvideWindowInsets
import com.steleot.jetpackcompose.playground.LocalInAppReviewer
import com.steleot.jetpackcompose.playground.MainActivity
import com.steleot.jetpackcompose.playground.helpers.EmptyInAppReviewHelper
import com.steleot.jetpackcompose.playground.theme.JetpackComposePlaygroundTheme
import com.steleot.jetpackcompose.playground.theme.ThemeState
import org.junit.Rule
import org.junit.Test

class ButtonScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private val inAppReviewHelper = EmptyInAppReviewHelper()

    @Test
    fun testButtonScreen() {
        composeTestRule.setContent {
            JetpackComposePlaygroundTheme(
                themeState = ThemeState(),
            ) {
                ProvideWindowInsets {
                    CompositionLocalProvider(LocalInAppReviewer provides inAppReviewHelper) {
                        ButtonScreen()
                    }
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