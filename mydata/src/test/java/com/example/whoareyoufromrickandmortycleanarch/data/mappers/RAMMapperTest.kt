package com.example.whoareyoufromrickandmortycleanarch.data.mappers

import com.example.whoareyoufromrickandmortycleanarch.data.remote.RickAndMortyDto
import com.example.whoareyoufromrickandmortycleanarch.domain.rickandmorty.RickAndMortyData
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock

internal class RAMMapperTest {

    val rickAndMortyDto = RickAndMortyDto(
        name = "Ilya",
        status = "Junior",
        species = "Android developer",
        type = "Human",
        gender = "Man",
        image = "Any String Res to Image"
    )

    val rickAndMortyData = RickAndMortyData(
        name = "Ilya",
        status = "Junior",
        species = "Android developer",
        type = "Human",
        gender = "Man",
        image = "Any String Res to Image"
    )

    @Test
    fun toRickAndMortyTest(){

        val actual = rickAndMortyDto.toRickAndMortyData()
        val expected = rickAndMortyData

        Assertions.assertEquals(expected,actual)

    }

}