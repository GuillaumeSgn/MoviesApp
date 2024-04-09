package com.example.projetfilms

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.projetfilms.details.DetailsPage


@Composable
fun Nav() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "menu") {
        composable("menu") {
            ListMovies(toDetails = { id ->
                navController.navigate("details/$id")
            })
        }
        composable(
            "details/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->
            DetailsPage(backTo = {
                navController.navigate("menu") {
                    popUpTo("details") {
                        inclusive = true
                    }
                }
            }, backStackEntry.arguments?.getInt("id"))
        }
    }
}
