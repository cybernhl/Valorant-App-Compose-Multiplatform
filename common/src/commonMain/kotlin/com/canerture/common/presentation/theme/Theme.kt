package com.canerture.common.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Composable
public fun ValorantTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        darkColors
    } else {
        lightColors
    }

    val windowType = rememberWindowType()

    CompositionLocalProvider(
        LocalValorantColors provides colors,
        LocalValorantTypography provides ValorantTypography(),
        LocalWindowType provides windowType
    ) {
        content()
    }
}

private val darkColors = ValorantColors(
    primary = White,
    secondary = Blue,
    background = Blue,
    defaultWhite = White,
    defaultBlue = Blue,
    defaultLightBlue = LightBlue,
    defaultRed = Red,
    navColors = NavColors(
        containerColor = LightBlue,
        selectedIconColor = Red,
        selectedTextColor = White,
        selectedIndicatorColor = Color.Transparent,
        unselectedIconColor = White.copy(0.3f),
        unselectedTextColor = White.copy(0.3f),
        disabledIconColor = White,
        disabledTextColor = White
    ),
    cardBackground = LightBlue,
    cardBackgroundSecondary = LightBlue
)

private val lightColors = ValorantColors(
    primary = Blue,
    secondary = White,
    background = White,
    defaultWhite = White,
    defaultBlue = Blue,
    defaultLightBlue = LightBlue,
    defaultRed = Red,
    navColors = NavColors(
        containerColor = LightBlue.copy(0.05f),
        selectedIconColor = Red,
        selectedTextColor = Blue,
        selectedIndicatorColor = Color.Transparent,
        unselectedIconColor = Blue.copy(0.3f),
        unselectedTextColor = Blue.copy(0.3f),
        disabledIconColor = Color.Transparent,
        disabledTextColor = Color.Transparent
    ),
    cardBackground = LightBlue.copy(0.05f),
    cardBackgroundSecondary = LightBlue.copy(0.1f)
)

public object ValorantTheme {
    public   val colors: ValorantColors
        @ReadOnlyComposable
        @Composable
        get() = LocalValorantColors.current

    public   val typography: ValorantTypography
        @ReadOnlyComposable
        @Composable
        get() = LocalValorantTypography.current
}

private val LocalValorantColors = staticCompositionLocalOf {
    ValorantColors(
        primary = Color.Unspecified,
        secondary = Color.Unspecified,
        background = Color.Unspecified,
        defaultWhite = Color.Unspecified,
        defaultBlue = Color.Unspecified,
        defaultLightBlue = Color.Unspecified,
        defaultRed = Color.Unspecified,
        navColors = NavColors(
            containerColor = Color.Unspecified,
            selectedIconColor = Color.Unspecified,
            selectedTextColor = Color.Unspecified,
            selectedIndicatorColor = Color.Unspecified,
            unselectedIconColor = Color.Unspecified,
            unselectedTextColor = Color.Unspecified,
            disabledIconColor = Color.Unspecified,
            disabledTextColor = Color.Unspecified
        ),
        cardBackground = Color.Unspecified,
        cardBackgroundSecondary = Color.Unspecified
    )
}

public val LocalValorantTypography: ProvidableCompositionLocal<ValorantTypography> = staticCompositionLocalOf { ValorantTypography() }

public val LocalWindowType: ProvidableCompositionLocal<WindowType> = staticCompositionLocalOf { WindowType.Small }

