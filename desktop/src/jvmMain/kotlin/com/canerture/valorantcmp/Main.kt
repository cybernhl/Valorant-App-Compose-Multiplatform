package com.canerture.valorantcmp

import androidx.compose.ui.Alignment
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.window.rememberWindowState
import com.canerture.common.UIShow
import com.canerture.common.di.initKoin
import java.awt.Dimension
import com.canerture.common.di.initKoin

private const val WINDOW_WIDTH = 1280
private const val WINDOW_HEIGHT = 760

fun main() = application {
    initKoin()
    val state = rememberWindowState(
        placement = WindowPlacement.Floating,
        position = WindowPosition(Alignment.Center)
    )
    Window(title = "Valorant CMP", onCloseRequest = ::exitApplication, state = state) {
        window.minimumSize = Dimension(WINDOW_WIDTH, WINDOW_HEIGHT)
//        MaterialTheme(colorScheme = if (isSystemInDarkTheme()) darkColorScheme() else lightColorScheme()) {
            UIShow()
//        }
    }
}
