package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.ui.test.junit4.createComposeRule
import com.steleot.jetpackcompose.playground.compose.theme.TestTheme
import com.steleot.jetpackcompose.playground.helpers.EmptySystemUiController
import org.junit.Rule
import org.junit.Test

class SystemUiControllerAccompanistScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testSystemUiControllerAccompanistScreen() {
        val systemUiController = EmptySystemUiController()
        composeTestRule.setContent {
            TestTheme {
                SystemUiControllerAccompanistScreen(systemUiController)
            }
        }
        // todo
    }
}