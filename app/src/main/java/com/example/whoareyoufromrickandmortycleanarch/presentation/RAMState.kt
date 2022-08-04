package com.example.whoareyoufromrickandmortycleanarch.presentation

import com.example.whoareyoufromrickandmortycleanarch.domain.rickandmorty.RickAndMortyData

data class RAMState(
    val RAMData:RickAndMortyData?=null,
    val isLoading:Boolean=false,
    val error:String?=null
)
