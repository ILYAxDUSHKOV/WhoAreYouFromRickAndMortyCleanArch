package com.example.whoareyoufromrickandmortycleanarch.presentation.composable

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.whoareyoufromrickandmortycleanarch.presentation.RAMViewModel

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    viewModel:RAMViewModel
){
    NavHost(
        navController = navController,
        startDestination = Screens.WhoAreYouScreen.route
    ){
        composable(
            route = Screens.WhoAreYouScreen.route
        ){
            WhoAreYouScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
        composable(
            route = Screens.InfoScreen.route
        ){
            InfoScreen(viewModel = viewModel)
        }
    }
}