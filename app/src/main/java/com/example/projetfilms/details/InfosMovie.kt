package com.example.projetfilms.details

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.projetfilms.fakedata.Movies

@Composable
fun InfosMovie(movie:Movies){
    Text(
        text = movie.title,
        style = MaterialTheme.typography.titleMedium,
    )
    Text(
        text = movie.genre,
        style = MaterialTheme.typography.labelLarge,
    )
}