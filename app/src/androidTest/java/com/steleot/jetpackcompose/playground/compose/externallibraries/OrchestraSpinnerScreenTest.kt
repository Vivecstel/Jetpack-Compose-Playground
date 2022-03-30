package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.ui.test.junit4.createComposeRule
import com.steleot.jetpackcompose.playground.compose.theme.TestTheme
import org.junit.Rule
import org.junit.Test

class OrchestraSpinnerScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testOrchestraSpinnerScreen() {
        composeTestRule.setContent {
            TestTheme {
                OrchestraSpinnerScreen()
            }
        }
        // todo
    }
}