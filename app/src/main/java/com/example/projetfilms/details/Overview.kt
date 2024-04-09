package com.example.projetfilms.details

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.projetfilms.fakedata.Movies

@Composable
fun Overview(movie: Movies) {
    Text(text = "Overview", style = MaterialTheme.typography.headlineMedium)
    Text(
        text = movie.synopsis,
        style = MaterialTheme.typography.bodySmall,
    )

}