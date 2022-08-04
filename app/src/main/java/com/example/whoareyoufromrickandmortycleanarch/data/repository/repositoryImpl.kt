package com.example.whoareyoufromrickandmortycleanarch.data.repository

import com.example.whoareyoufromrickandmortycleanarch.data.mappers.toRickAndMortyData
import com.example.whoareyoufromrickandmortycleanarch.data.remote.MyAPI
import com.example.whoareyoufromrickandmortycleanarch.domain.repository.repository
import com.example.whoareyoufromrickandmortycleanarch.domain.rickandmorty.RickAndMortyData
import com.example.whoareyoufromrickandmortycleanarch.domain.utill.Resource
import javax.inject.Inject

class repositoryImpl @Inject constructor(
    private val api:MyAPI
):repository {
    override suspend fun getRickAndMortyData(id: Int): Resource<RickAndMortyData> {
        return try {
            Resource.Success(
                data = api.getRickAndMortyDto(id).toRickAndMortyData()
            /*Насколько уместно здесь в аргумент передавать Random.nextInt?*/
            /*Убрал. Кажется, не уместно.*/
            )
        } catch (e:Exception){
            Resource.Error(
                message = e.message ?: "Need internet connection"
            )
        }
    }

}