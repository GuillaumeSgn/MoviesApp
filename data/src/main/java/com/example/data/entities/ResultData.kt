package com.example.data.entities

import com.example.domain.model.Results
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResultData(
    val page: Int,
    val results: List<MoviesData>
)

fun ResultData.mapToDomain(): Results = Results(
    page = page,
    results = results.map { it.mapToDomain() }
)
