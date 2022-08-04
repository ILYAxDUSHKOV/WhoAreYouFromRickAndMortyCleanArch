package com.example.whoareyoufromrickandmortycleanarch.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.whoareyoufromrickandmortycleanarch.presentation.RAMViewModel
import com.example.whoareyoufromrickandmortycleanarch.presentation.composable.SetupNavGraph
import com.example.whoareyoufromrickandmortycleanarch.presentation.ui.theme.WhoAreYouFromRickAndMortyCleanArchTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel:RAMViewModel by viewModels()
    private lateinit var navController:NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.LoadRAMData()
        setContent {
            WhoAreYouFromRickAndMortyCleanArchTheme {
                navController = rememberNavController()
                SetupNavGraph(
                    navController = navController,
                    viewModel = viewModel
                )
            }
        }
    }
}
