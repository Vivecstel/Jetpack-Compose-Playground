package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.test.assertHeightIsEqualTo
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertWidthIsEqualTo
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.ProvideWindowInsets
import com.steleot.jetpackcompose.playground.LocalInAppReviewer
import com.steleot.jetpackcompose.playground.MainActivity
import com.steleot.jetpackcompose.playground.helpers.EmptyInAppReviewHelper
import com.steleot.jetpackcompose.playground.theme.JetpackComposePlaygroundTheme
import com.steleot.jetpackcompose.playground.theme.ThemeState
import org.junit.Rule
import org.junit.Test

class TestTagScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private val inAppReviewHelper = EmptyInAppReviewHelper()

    @Test
    fun testTestTagScreen() {
        composeTestRule.setContent {
            JetpackComposePlaygroundTheme(
                themeState = ThemeState()
            ) {
                ProvideWindowInsets {
                    CompositionLocalProvider(LocalInAppReviewer provides inAppReviewHelper) {
                        TestTagScreen()
                    }
                }
            }
        }

        composeTestRule
            .onNodeWithTag("test_tag")
            .assertIsDisplayed()
            .assertHeightIsEqualTo(60.dp)
            .assertWidthIsEqualTo(60.dp)
    }
}