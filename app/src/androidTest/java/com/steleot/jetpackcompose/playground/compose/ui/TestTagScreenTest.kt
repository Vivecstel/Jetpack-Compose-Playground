package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.ui.test.assertHeightIsEqualTo
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertWidthIsEqualTo
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.compose.theme.TestTheme
import org.junit.Rule
import org.junit.Test

class TestTagScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testTestTagScreen() {
        composeTestRule.setContent {
            TestTheme {
                TestTagScreen()
            }
        }

        composeTestRule
            .onNodeWithTag("test_tag")
            .assertIsDisplayed()
            .assertHeightIsEqualTo(60.dp)
            .assertWidthIsEqualTo(60.dp)
    }
}