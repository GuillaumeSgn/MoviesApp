package com.example.projetfilms.details

import androidx.compose.runtime.Composable
import com.example.projetfilms.carrouselLine.LineOfActor
import com.example.projetfilms.fakedata.Actor

@Composable
fun ActorsCarrousel(actors: List<Actor>) {
   LineOfActor(actors = actors, title = "Cast")
}