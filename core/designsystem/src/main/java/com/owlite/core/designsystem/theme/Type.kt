package com.owlite.core.designsystem.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import com.owlite.core.designsystem.R

/**
 * Define font used in Shelter It
 */
val fontName = GoogleFont("Fredoka")
val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs,
)
val fontFamily = FontFamily(
    Font(googleFont = fontName, fontProvider = provider),
)
internal val ShelterItTypography = Typography(
    displayLarge = TODO(),
    displayMedium = TODO(),
    displaySmall = TODO(),
    headlineLarge = TODO(),
    headlineMedium = TODO(),
    headlineSmall = TODO(),
    titleLarge = TODO(),
    titleMedium = TODO(),
    titleSmall = TODO(),
    bodyLarge = TODO(),
    bodyMedium = TODO(),
    bodySmall = TODO(),
    labelLarge = TODO(),
    labelMedium = TODO(),
    labelSmall = TODO()
)
