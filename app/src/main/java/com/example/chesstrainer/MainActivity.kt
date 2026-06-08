package com.example.chesstrainer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.chesstrainer.screens.StartScreen
import com.example.chesstrainer.ui.theme.ChessTrainerTheme
import com.example.chesstrainer.screens.WelcomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ChessTrainer()
        }
    }
}

@Composable
fun ChessTrainer() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "welcome"
    ) {
        composable("welcome") {
            WelcomeScreen(navController)
        }

        composable("start/{username}") { backStackEntry ->
            val username =
                backStackEntry.arguments?.getString("username") ?: ""

            StartScreen(navController, username)
        }
/*
        composable("openings") {
            OpeningsScreen(navController)
        }

        composable("puzzles") {
            PuzzlesScreen(navController)
        }
        */
    }
}