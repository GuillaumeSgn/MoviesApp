package com.example.projetfilms.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetfilms.network.FilmApi
import kotlinx.coroutines.launch

class VuModel : ViewModel() {
    private val _status = MutableLiveData<String>()
    val status: LiveData<String> = _status

    init {
        getListMoviePopular()
    }

    private fun getListMoviePopular() {
        viewModelScope.launch {
            try {
                val listM = FilmApi.retrofitService.getListPopular()
                _status.value = "Success: ${listM.size} movies retrieved"
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }
}