package com.example.whoareyoufromrickandmortycleanarch.data.remote

import retrofit2.http.GET
import retrofit2.http.Path

interface MyAPI {
    @GET("api/character/{characterId}")
    suspend fun getRickAndMortyDto(
        @Path("characterId") characterId:Int
    ):RickAndMortyDto
}