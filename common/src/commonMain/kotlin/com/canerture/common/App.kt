package com.canerture.common

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.canerture.common.common.Routes
import com.canerture.common.navigation.ValorantNavigation
import com.canerture.common.navigation.ValorantNavigationBar
import com.canerture.common.navigation.ValorantNavigationRail
import com.canerture.common.presentation.theme.LocalWindowType
import com.canerture.common.presentation.theme.ValorantTheme
import com.canerture.common.presentation.theme.WindowType
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
internal fun App() {
    ValorantTheme {
        val windowType = LocalWindowType.current
        val navController = rememberNavController()
        var navigationBarShowState by remember { mutableStateOf(false) }
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        navigationBarShowState = navBackStackEntry?.destination?.route != Routes.SPLASH
        Scaffold(
            bottomBar = {
                if (windowType == WindowType.Small && navigationBarShowState) {
                    AnimatedVisibility(visible = navigationBarShowState) {
                        ValorantNavigationBar(navController)
                    }
                }
            },
            containerColor = ValorantTheme.colors.background
        ) { innerPadding ->
            if (windowType != WindowType.Small) {
                Row(Modifier.padding(innerPadding)) {
                    if (navigationBarShowState) {
                        AnimatedVisibility(visible = navigationBarShowState) {
                            ValorantNavigationRail(navController)
                        }
                    }
                    Box(Modifier.weight(1f)) { ValorantNavigation(navController) }
                }
            } else {
                Box(Modifier.padding(innerPadding)) { ValorantNavigation(navController) }
            }
        }
    }
}