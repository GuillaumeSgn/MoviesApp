package com.example.projetfilms.carrouselLine

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.projetfilms.carrouselCard.ActorCard
import com.example.projetfilms.fakedata.Actor

@Composable
fun LineOfActor(
    actors: List<Actor>,
    title:String
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.absolutePadding(left = 24.dp)
    ) {
        Text(text = title, style = MaterialTheme.typography.headlineMedium)
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(items = actors) {
                ActorCard(actor = it)
            }
        }
    }
}