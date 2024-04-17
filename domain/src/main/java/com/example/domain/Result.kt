package com.example.domain

import com.example.projetfilms.fakedata.Movies

data class Result(
    val page: Int,
    val results: List<Movies>
)
