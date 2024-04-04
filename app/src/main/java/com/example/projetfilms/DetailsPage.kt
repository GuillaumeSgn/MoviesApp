package com.example.projetfilms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun DetailsPage(backTo: () -> Unit) {

    Column {
        IconButton(onClick = backTo ) {
            Icon(imageVector = Icons.Outlined.ArrowBack,"Back",modifier= Modifier)
        }
        Text(text = "image du film")
        Text(text = "titre du film")
        Text(text = "date,durée et autres")
        Buttons()
        Text(text = "Overview")
        Text(text = "résumé du film")
        Text(text = "Cast")
        Carousel()
    }
}


@Composable
fun Buttons(){
    Row{
        Text(text = "bouton download")
        Text(text = "bouton share")
        Text(text = "bouton favorites")
    }
}

@Composable
fun Carousel(){
    Row {
        Column {
            Text(text = "les photos")
        }
    }
}