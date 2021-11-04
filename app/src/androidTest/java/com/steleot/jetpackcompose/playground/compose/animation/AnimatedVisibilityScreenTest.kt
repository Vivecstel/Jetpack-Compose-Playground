package com.steleot.jetpackcompose.playground.compose.animation

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.steleot.jetpackcompose.playground.MainActivity
import com.steleot.jetpackcompose.playground.compose.activity.LauncherForActivityResult1Screen
import com.steleot.jetpackcompose.playground.compose.theme.TestTheme
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class AnimatedVisibilityScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testBackHandlerScreen() {
        composeTestRule.setContent {
            TestTheme {
                AnimatedVisibilityScreen()
            }
        }
        // todo
    }
}