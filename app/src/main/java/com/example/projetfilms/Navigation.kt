package com.example.projetfilms

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun Nav() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "menu") {
        composable("menu") { ListMovies(toDetails = {navController.navigate("details")}) }
        composable("details") { DetailsPage(backTo= {navController.navigate("menu"){ popUpTo("details"){inclusive = true} } }) }
    }
}
