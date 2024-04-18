package com.example.presentation.home

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.presentation.details.DetailsPage

@Composable
fun Nav() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "menu") {
        composable("menu") {
            ListMovies(toDetails = { id ->
                navController.navigate("details/$id")
            }, viewModel = hiltViewModel())
        }
        composable(
            "details/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->
            backStackEntry.arguments?.getInt("id")?.let {
                DetailsPage(
                    backTo = {
                        navController.navigate("menu") {
                            popUpTo("details") {
                                inclusive = true
                            }
                        }
                    },
                    id = it,
                    viewModel = hiltViewModel()
                )
            }
        }
    }
}
