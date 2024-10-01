package com.canerture.common.presentation.theme

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable

@Composable
public fun rememberWindowType(): WindowType {
    val type = calculateWindowSizeClass().widthSizeClass
    return if (type <= WindowWidthSizeClass.Compact) {
        WindowType.Small
    } else if (type <= WindowWidthSizeClass.Medium) {
        WindowType.Medium
    } else {
        WindowType.Large
    }
}

public enum class WindowType {
    Small, Medium, Large
}
