package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import com.steleot.jetpackcompose.playground.MainActivity
import com.steleot.jetpackcompose.playground.compose.theme.TestTheme
import com.steleot.jetpackcompose.playground.helpers.EmptySystemUiController
import org.junit.Rule
import org.junit.Test

class SystemUiControllerAccompanistScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testSystemUiControllerAccompanistScreen() {
        val navController = TestNavHostController(ApplicationProvider.getApplicationContext())
        val systemUiController = EmptySystemUiController()
        composeTestRule.setContent {
            TestTheme {
                SystemUiControllerAccompanistScreen(navController, systemUiController)
            }
        }
        // todo
    }
}