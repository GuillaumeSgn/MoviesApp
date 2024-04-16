package com.example.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import com.example.projetfilms.R

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

val fontName = GoogleFont("Roboto")
val roboto = FontFamily(Font(googleFont = fontName, fontProvider = provider))

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleSmall = TextStyle(
        fontFamily = roboto,
        fontWeight = FontWeight(500),
        fontSize = 14.sp,
    ),
    labelSmall = TextStyle(
        fontFamily = roboto,
        fontSize = 12.sp,
        fontWeight = FontWeight(400),
    ),
    titleMedium = TextStyle(
        fontFamily = roboto,
        fontSize = 26.sp,
        fontWeight = FontWeight(300),
    ),

    // Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = roboto,
        fontWeight = FontWeight(500),
        fontSize = 28.sp,
    ),
    labelMedium = TextStyle(
        fontSize = 14.sp,
        fontFamily = roboto,
        fontWeight = FontWeight(400),
    ),
    headlineMedium = TextStyle(
        fontSize = 18.sp,
        fontFamily = roboto,
        fontWeight = FontWeight(500),
    ),
    bodySmall = TextStyle(
        fontSize = 14.sp,
        lineHeight = 20.sp,
        fontFamily = roboto,
        fontWeight = FontWeight(400),
    ),
    labelLarge = TextStyle(
        fontSize = 16.sp,
        fontFamily = roboto,
        fontWeight = FontWeight(400)
    )
)
