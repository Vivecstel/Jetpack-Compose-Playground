package com.steleot.jetpackcompose.playground.compose.material3

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.steleot.jetpackcompose.playground.MainActivity
import com.steleot.jetpackcompose.playground.compose.theme.TestTheme3
import org.junit.Rule
import org.junit.Test

class BadgeScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testBadgeScreen() {
        composeTestRule.setContent {
            TestTheme3 {
                Badge3Screen()
            }
        }
        // todo
    }
}