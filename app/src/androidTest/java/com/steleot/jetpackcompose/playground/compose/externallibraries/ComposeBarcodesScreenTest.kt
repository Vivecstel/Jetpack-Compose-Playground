package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.steleot.jetpackcompose.playground.MainActivity
import com.steleot.jetpackcompose.playground.compose.theme.TestTheme
import org.junit.Rule
import org.junit.Test

class ComposeBarcodesScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testComposeBarcodesScreen() {
        composeTestRule.setContent {
            TestTheme {
                ComposeBarcodesScreen()
            }
        }
        // todo
    }
}