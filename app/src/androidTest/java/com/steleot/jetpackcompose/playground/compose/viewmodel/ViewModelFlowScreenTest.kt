package com.steleot.jetpackcompose.playground.compose.viewmodel

import androidx.compose.ui.test.junit4.createComposeRule
import com.steleot.jetpackcompose.playground.compose.theme.TestTheme
import org.junit.Rule
import org.junit.Test

class ViewModelFlowScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testViewModelFlowScreen() {
        composeTestRule.setContent {
            TestTheme {
//                ViewModelFlowScreen()
            }
        }
        // todo
    }
}