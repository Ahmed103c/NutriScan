package com.example.nutriscan.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.nutriscan.screens.DataPage
import com.example.nutriscan.screens.HistoryPage
import com.example.nutriscan.screens.HomePage


@Composable
fun AppNavHost(
    navController: androidx.navigation.NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Route.HomePage
    ) {

        composable<Route.HomePage> {
            HomePage(
                navigateToHistory = {
                    navController.navigate(Route.HistoryPage)
                },
                navigateToData = {
                    navController.navigate(Route.DataPage)
                }
            )
        }
        composable<Route.DataPage> {
            DataPage {
                navController.popBackStack()
            }
        }

        composable<Route.HistoryPage> {
            HistoryPage {
                navController.popBackStack()
            }
        }


    }
}

