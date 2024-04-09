package com.example.projetfilms.details

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.projetfilms.ui.theme.GreenBorder
import com.example.projetfilms.ui.theme.RedBorder

@Composable
fun Buttons() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CustomButton(imageVector = Icons.Filled.Download, color = GreenBorder, text = "Download")
        CustomButton(imageVector = Icons.Outlined.Share, color = GreenBorder, text = "Share")
        CustomButton(
            imageVector = Icons.Filled.FavoriteBorder,
            color = RedBorder,
            text = "Add To Favorites"
        )
    }
}

@Composable
fun CustomButton(imageVector: ImageVector, color: Color, text: String) {
    TextButton(
        onClick = {},
        modifier = Modifier
            .border(
                width = 1.dp,
                color = color,
                shape = RoundedCornerShape(size = 8.dp)
            )
    )
    {
        Icon(
            imageVector = imageVector,
            contentDescription = null
        )
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium
        )
    }
}