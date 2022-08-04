package com.example.whoareyoufromrickandmortycleanarch.presentation.composable

sealed class Screens(val route:String){
    object WhoAreYouScreen:Screens("WhoAreYouScreen")
    object InfoScreen:Screens("InfoScreen")
}
