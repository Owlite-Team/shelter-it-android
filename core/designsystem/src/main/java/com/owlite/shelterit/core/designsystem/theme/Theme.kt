package com.owlite.shelterit.core.designsystem.theme

import android.os.Build
import androidx.activity.ComponentActivity
import androidx.annotation.ChecksSdkIntAtLeast
import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalContext

/**
 * @author Novita
 * @see <a href="https://www.figma.com/design/7QHjQINgUGrS4pUjEnLueg/Miaw-Design-System?node-id=507-145&t=VvCTcm7mHN1r0LfN-4">Miaw DS - Light Theme</a>
 */
@VisibleForTesting
val LightDefaultColorScheme = lightColorScheme(
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
val DarkDefaultColorScheme = darkColorScheme(
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

@VisibleForTesting
val LightAndroidColorScheme = lightColorScheme(
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

@VisibleForTesting
val DarkAndroidColorScheme = darkColorScheme(
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

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun ShelterItTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    androidTheme: Boolean = false,
    disableDynamicTheming: Boolean = true,
    content: @Composable () -> Unit,
) {
    // Color scheme
    val colorScheme = when {
        androidTheme -> if (darkTheme) DarkAndroidColorScheme else LightAndroidColorScheme
        !disableDynamicTheming && supportsDynamicTheming() -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        else -> if (darkTheme) DarkDefaultColorScheme else LightDefaultColorScheme
    }

    val context = LocalContext.current
    val windowSizeClass = calculateWindowSizeClass(context as ComponentActivity)
    val spacing = when (windowSizeClass.widthSizeClass) {
        WindowWidthSizeClass.Compact -> ShelterItDimension.compact
        WindowWidthSizeClass.Medium -> ShelterItDimension.medium
        WindowWidthSizeClass.Expanded -> ShelterItDimension.expanded
        else -> ShelterItDimension.medium
    }

    CompositionLocalProvider(
        LocalSpacing provides spacing,
        LocalComponentDimensions provides ComponentDimensions()
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = ShelterItTypography,
            content = content
        )
    }
}

@ChecksSdkIntAtLeast(api = Build.VERSION_CODES.S)
fun supportsDynamicTheming() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S
