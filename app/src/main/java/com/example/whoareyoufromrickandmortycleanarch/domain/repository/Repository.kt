package com.example.whoareyoufromrickandmortycleanarch.domain.repository

import com.example.whoareyoufromrickandmortycleanarch.domain.rickandmorty.RickAndMortyData
import com.example.whoareyoufromrickandmortycleanarch.domain.utill.Resource

interface repository {
    suspend fun getRickAndMortyData(id:Int):Resource<RickAndMortyData>
}