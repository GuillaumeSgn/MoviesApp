package com.example.presentation.details

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.domain.Casting
import com.example.presentation.carrouselLine.LineOfActor
import com.example.presentation.theme.ProjetFilmsTheme

@Composable
fun ActorsCarrousel(actors: List<Casting?>) {
    LineOfActor(actors = actors, title = "Cast")
}

@Preview
@Composable
fun PreviewActorsCarrousel() {
    val actors = Casting(name = "truc", picture = "truc", character = "truc", job = "truc")
    ProjetFilmsTheme {
        ActorsCarrousel(actors = listOf(actors, actors))
    }
}
