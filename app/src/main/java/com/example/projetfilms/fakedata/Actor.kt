package com.example.projetfilms.fakedata

data class Actor(
    val name: String,
    val role: String
) {

    companion object {

        fun fakeActor() = listOf(
            Actor("Morgan Freeman", "Mufasa (voice)"),
            Actor("Tom Hanks", "Simba (voice)"),
            Actor("Machin", "truc (voice)")
        )
    }

}

fun getActors() = Actor.fakeActor()