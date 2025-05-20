package com.owlite.shelterit.core.designsystem.theme

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Spacing(
    val extraSmall: Dp = 4.dp,
    val small: Dp = 8.dp,
    val medium: Dp = 16.dp,
    val large: Dp = 24.dp,
    val extraLarge: Dp = 32.dp,
    val huge: Dp = 48.dp
)

data class ComponentDimensions(
    val buttonHeight: Dp = 48.dp,
    val buttonMinWidth: Dp = 64.dp,
    val iconSize: Dp = 24.dp,
    val iconSizeSmall: Dp = 16.dp,
    val iconSizeLarge: Dp = 32.dp,
    val avatarSize: Dp = 40.dp,
    val avatarSizeLarge: Dp = 56.dp,
    val cardElevation: Dp = 4.dp,
    val cornerRadius: Dp = 8.dp,
    val cornerRadiusLarge: Dp = 16.dp,
    val dividerThickness: Dp = 1.dp,
    val minTouchTarget: Dp = 48.dp
)

object ShelterItDimension {
    val compact = Spacing(
        extraSmall = 2.dp,
        small = 4.dp,
        medium = 8.dp,
        large = 16.dp,
        extraLarge = 24.dp,
        huge = 32.dp
    )

    val medium = Spacing(
        extraSmall = 4.dp,
        small = 8.dp,
        medium = 16.dp,
        large = 24.dp,
        extraLarge = 32.dp,
        huge = 48.dp
    )

    val expanded = Spacing(
        extraSmall = 6.dp,
        small = 12.dp,
        medium = 24.dp,
        large = 32.dp,
        extraLarge = 48.dp,
        huge = 64.dp
    )
}

val LocalSpacing = compositionLocalOf { Spacing() }
val LocalComponentDimensions = compositionLocalOf { ComponentDimensions() }

//fun Modifier.standardPadding(): Modifier = this.padding(LocalSpacing.current.medium)
//fun Modifier.cardPadding(): Modifier = this.padding(
//    horizontal = LocalSpacing.current.medium,
//    vertical = LocalSpacing.current.small
//)
//fun Modifier.screenPadding(): Modifier = this.padding(LocalSpacing.current.medium)
//fun Modifier.iconSize(): Modifier = this.size(LocalComponentDimensions.current.iconSize)
//fun Modifier.touchTarget(): Modifier = this.size(LocalComponentDimensions.current.minTouchTarget)