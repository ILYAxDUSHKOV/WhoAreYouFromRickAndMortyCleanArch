package com.example.whoareyoufromrickandmortycleanarch.data.mappers

import com.example.whoareyoufromrickandmortycleanarch.data.remote.RickAndMortyDto
import com.example.whoareyoufromrickandmortycleanarch.domain.rickandmorty.RickAndMortyData

fun RickAndMortyDto.toRickAndMortyData():RickAndMortyData{
    val mapperName = name
    val mapperStatus = status
    val mapperSpecies = species
    val mapperType = type
    val mapperGender = gender
    val mapperImage = image
    return RickAndMortyData(
            name = mapperName,
            status = mapperStatus,
            species = mapperSpecies,
            type = mapperType,
            gender = mapperGender,
            image = mapperImage
        )
}