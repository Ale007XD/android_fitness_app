package com.fitnessapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fitnessapp.ui.home.HomeScreen
import com.fitnessapp.ui.nutrition.NutritionScreen
import com.fitnessapp.ui.workouts.WorkoutScreen
import com.fitnessapp.ui.calendar.CalendarScreen
import com.fitnessapp.ui.progress.ProgressScreen
import com.fitnessapp.ui.settings.SettingsScreen
import com.fitnessapp.ui.theme.AndroidFitnessAppTheme

class MainActivity : ComponentActivity() {
    override fun fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidFitnessAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FitnessAppNavigation()
                }
            }
        }
    }
}

@Composable
fun FitnessAppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen()
        }
        composable("workouts") {
            WorkoutScreen()
        }
        composable("nutrition") {
            NutritionScreen()
        }
        composable("calendar") {
            CalendarScreen()
        }
        composable("progress") {
            ProgressScreen()
        }
        composable("settings") {
            SettingsScreen()
        }
    }
}



// TODO: Implement comprehensive testing (unit, integration, UI) for all features.
// TODO: Optimize performance and user experience based on testing results.


