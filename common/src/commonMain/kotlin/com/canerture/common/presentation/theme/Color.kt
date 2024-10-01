package com.canerture.common.presentation.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

public val Blue: Color = Color(0xFF161C23)
public val LightBlue: Color = Color(0xFF212830)
public val Red: Color = Color(0xFFFF4654)
public val White: Color = Color(0xFFFFFDF1)

@Immutable
public data class ValorantColors(
    val primary: Color,
    val secondary: Color,
    val background: Color,
    val defaultWhite: Color,
    val defaultBlue: Color,
    val defaultLightBlue: Color,
    val defaultRed: Color,
    val navColors: NavColors,
    val cardBackground: Color,
    val cardBackgroundSecondary: Color,
)

@Immutable
public data class NavColors(
    val containerColor: Color,
    val selectedIconColor: Color,
    val selectedTextColor: Color,
    val selectedIndicatorColor: Color,
    val unselectedIconColor: Color,
    val unselectedTextColor: Color,
    val disabledIconColor: Color,
    val disabledTextColor: Color
)
