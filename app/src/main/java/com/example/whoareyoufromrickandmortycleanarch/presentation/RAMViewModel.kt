package com.example.whoareyoufromrickandmortycleanarch.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.whoareyoufromrickandmortycleanarch.domain.repository.repository
import com.example.whoareyoufromrickandmortycleanarch.domain.utill.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random
import kotlin.random.nextInt

@HiltViewModel
class RAMViewModel @Inject constructor(
    val repository:repository
):ViewModel() {
    var state by mutableStateOf(RAMState())

    fun LoadRAMData(){
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )

            when(val result = repository.getRickAndMortyData(Random.nextInt(1..120))){
                is Resource.Success -> {
                    state = state.copy(
                        RAMData = result.data,
                        isLoading = false,
                        error = null
                    )
                }
                is Resource.Error -> {
                    state = state.copy(
                        RAMData = null,
                        isLoading = false,
                        error = result.message
                    )
                }
            } /*?: kotlin.run {
                state = state.copy(
                    isLoading = false,
                    error = "Какая-то ошибка"
                )
            }*/
        }
    }
}