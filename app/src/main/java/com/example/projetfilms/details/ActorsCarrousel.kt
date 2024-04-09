package com.example.projetfilms.details

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.projetfilms.carrouselLine.LineOfActor
import com.example.projetfilms.fakedata.Actor
import com.example.projetfilms.fakedata.getActors
import com.example.projetfilms.ui.theme.ProjetFilmsTheme

@Composable
fun ActorsCarrousel(actors: List<Actor>) {
    LineOfActor(actors = actors, title = "Cast")
}


@Preview
@Composable
fun PreviewActorsCarrousel() {
    ProjetFilmsTheme {
        ActorsCarrousel(actors = getActors())
    }
}