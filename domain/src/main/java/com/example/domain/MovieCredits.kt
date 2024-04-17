package com.example.domain

import com.example.projetfilms.network.Casting

data class MovieCredits(
    val id: Int,
    val cast: List<Casting>
)
