package com.example.whoareyoufromrickandmortycleanarch.data.mappers

import com.example.whoareyoufromrickandmortycleanarch.data.remote.RickAndMortyDto
import com.example.whoareyoufromrickandmortycleanarch.domain.rickandmorty.RickAndMortyData

fun RickAndMortyDto.toRickAndMortyData():RickAndMortyData{
    val name = name
    val status = status
    val species = species
    val type = type
    val gender = gender
    val image = image
    return RickAndMortyData(
            name = name,
            status = status,
            species = species,
            type = type,
            gender = gender,
            image = image
        )
}