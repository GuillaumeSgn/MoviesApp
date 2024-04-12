package com.example.projetfilms.details

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.projetfilms.carrouselLine.LineOfActor
import com.example.projetfilms.network.Casting
import com.example.projetfilms.ui.theme.ProjetFilmsTheme

@Composable
fun ActorsCarrousel(actors: List<Casting?>) {
    LineOfActor(actors = actors, title = "Cast")
}


@Preview
@Composable
fun PreviewActorsCarrousel() {
    ProjetFilmsTheme {
//        ActorsCarrousel(actors = getActors())
    }
}