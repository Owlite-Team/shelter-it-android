package com.owlite.shelterit.core.designsystem.theme

import android.os.Build
import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

/**
 * @author Novita
 * @see <a href="https://www.figma.com/design/7QHjQINgUGrS4pUjEnLueg/Miaw-Design-System?node-id=507-145&t=VvCTcm7mHN1r0LfN-4">Miaw DS - Light Theme</a>
 */
@VisibleForTesting
val LightColorScheme = lightColorScheme(
    primary = Brown70,
    onPrimary = Brown20,
    primaryContainer = Brown30,
    onPrimaryContainer = Brown90,
    secondary = Brown50,
    onSecondary = Brown90,
    secondaryContainer = Brown40,
    onSecondaryContainer = Brown95,
    tertiary = Pink70,
    onTertiary = White,
    tertiaryContainer = Pink30,
    onTertiaryContainer = Pink95,
    error = Red70,
    onError = White,
    errorContainer = Red20,
    onErrorContainer = Red95,
    background = Brown20,
    onBackground = Gray90,
    surface = White,
    onSurface = Gray90,
    surfaceVariant = Cream30,
    onSurfaceVariant = Cream90,
    inverseSurface = Brown90,
    inverseOnSurface = Brown30,
    outline = Cream70,
)

/**
 * @author Novita
 * @see <a href="https://www.figma.com/design/7QHjQINgUGrS4pUjEnLueg/Miaw-Design-System?node-id=517-2&t=VvCTcm7mHN1r0LfN-4">Miaw DS - Dark Theme</a>
 */
@VisibleForTesting
val DarkColorScheme = darkColorScheme(
    primary = Brown30,
    onPrimary = Brown90,
    primaryContainer = Cream90,
    onPrimaryContainer = Brown40,
    secondary = Brown40,
    onSecondary = Brown95,
    secondaryContainer = Cream90,
    onSecondaryContainer = Brown50,
    tertiary = Pink50,
    onTertiary = Pink95,
    tertiaryContainer = Pink90,
    onTertiaryContainer = Pink30,
    error = Red40,
    onError = Red90,
    errorContainer = Red80,
    onErrorContainer = Red30,
    background = Gray90,
    onBackground = Brown30,
    surface = Gray90,
    onSurface = Brown30,
    surfaceVariant = Cream95,
    onSurfaceVariant = Brown50,
    inverseSurface = Brown30,
    inverseOnSurface = Brown90,
    outline = Cream70,
)

@Composable
fun ShelterItTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = ShelterItTypography,
        content = content
    )
}
