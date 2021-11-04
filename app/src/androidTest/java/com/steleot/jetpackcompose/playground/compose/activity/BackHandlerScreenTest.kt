package com.steleot.jetpackcompose.playground.compose.activity

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import com.steleot.jetpackcompose.playground.MainActivity
import com.steleot.jetpackcompose.playground.compose.theme.TestTheme
import org.junit.Rule
import org.junit.Test

class BackHandlerScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testBackHandlerScreen() {
        val navController = TestNavHostController(ApplicationProvider.getApplicationContext())
        composeTestRule.setContent {
            TestTheme {
                BackHandlerScreen(navController)
            }
        }
        // todo
    }
}