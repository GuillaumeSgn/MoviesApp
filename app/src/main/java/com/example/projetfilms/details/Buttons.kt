package com.example.projetfilms.details

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.projetfilms.ui.theme.GreenBorder
import com.example.projetfilms.ui.theme.ProjetFilmsTheme
import com.example.projetfilms.ui.theme.RedBorder

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Buttons() {
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .absolutePadding(right = 20.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
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
            contentDescription = null,
            modifier = Modifier.padding(end = 8.dp)
        )
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
    }
}

@Preview
@Composable
fun PreviewButton(){
    ProjetFilmsTheme {
        Buttons()
    }
}