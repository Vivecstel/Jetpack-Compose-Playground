package com.steleot.jetpackcompose.playground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.steleot.jetpackcompose.playground.compose.material.MaterialScreen
import com.steleot.jetpackcompose.playground.navigation.MainNavRoutes

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeApp()
        }
    }
}

@Composable
fun JetpackComposeApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MainNavRoutes.Main) {
        /* main */
        composable(route = MainNavRoutes.Main) { MainScreen(navController) }
        composable(route = MainNavRoutes.Material) { MaterialScreen(navController) }
    }
}
