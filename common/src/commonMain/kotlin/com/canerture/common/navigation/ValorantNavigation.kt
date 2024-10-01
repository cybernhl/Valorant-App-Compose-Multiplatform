package com.canerture.common.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.canerture.common.common.Params
import com.canerture.common.common.Routes
import com.canerture.common.presentation.agentdetail.AgentDetailScreen
import com.canerture.common.presentation.agentdetail.AgentDetailViewModel
import com.canerture.common.presentation.agents.AgentsScreen
import com.canerture.common.presentation.agents.AgentsViewModel
import com.canerture.common.presentation.mapdetail.MapDetailScreen
import com.canerture.common.presentation.mapdetail.MapDetailViewModel
import com.canerture.common.presentation.maps.MapsScreen
import com.canerture.common.presentation.maps.MapsViewModel
import com.canerture.common.presentation.splash.SplashScreen
import com.canerture.common.presentation.tiers.TiersScreen
import com.canerture.common.presentation.tiers.TiersViewModel
import com.canerture.common.presentation.weapondetail.WeaponDetailScreen
import com.canerture.common.presentation.weapondetail.WeaponDetailViewModel
import com.canerture.common.presentation.weapons.WeaponsScreen
import com.canerture.common.presentation.weapons.WeaponsViewModel
import org.koin.compose.koinInject

private const val DURATION = 1000

@Composable
fun ValorantNavigation(
    navHostController: NavHostController,
) {
    val enterAnim = fadeIn(tween(DURATION))
    val exitAnim = fadeOut(tween(DURATION))

    NavHost(
        navController = navHostController,
        startDestination = Routes.SPLASH,
        enterTransition = { enterAnim },
        exitTransition = { exitAnim },
        popEnterTransition = { enterAnim },
        popExitTransition = { exitAnim }
    ) {
        composable(Routes.SPLASH) {
            SplashScreen(
                onNavigateAgentsScreen = { navHostController.navigate(Routes.AGENTS) }
            )
        }
        composable(Routes.AGENTS) {
            val viewModel: AgentsViewModel = koinInject()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect
            LaunchedEffect(Unit) {
                viewModel.getAgents()
            }
            AgentsScreen(
                uiState = uiState,
                uiEffect = uiEffect,
                onAction = viewModel::onAction,
                onNavigateAgentDetail = { agentId ->
                    navHostController.navigate(Routes.AGENT_DETAIL.plus("/$agentId"))
                }
            )
        }
        composable(Routes.AGENT_DETAIL_WITH_PARAM) { backStackEntry ->
            val agentId = backStackEntry.arguments?.getString(Params.AGENT_ID)
            val viewModel: AgentDetailViewModel = koinInject()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect
            LaunchedEffect(Unit) {
                viewModel.getAgentDetail(agentId.orEmpty())
            }
            AgentDetailScreen(
                uiState = uiState,
                uiEffect = uiEffect,
                onAction = viewModel::onAction,
                onBackClick = { navHostController.popBackStack() },
            )
        }
        composable(Routes.MAPS) {
            val viewModel: MapsViewModel = koinInject()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect
            LaunchedEffect(Unit) {
                viewModel.getMaps()
            }
            MapsScreen(
                uiState = uiState,
                uiEffect = uiEffect,
                onAction = viewModel::onAction,
                onNavigateMapDetail = { mapId ->
                    navHostController.navigate(Routes.MAP_DETAIL.plus("/$mapId"))
                }
            )
        }
        composable(Routes.MAP_DETAIL_WITH_PARAM) { backStackEntry ->
            val mapId = backStackEntry.arguments?.getString(Params.MAP_ID)
            val viewModel: MapDetailViewModel = koinInject()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect
            LaunchedEffect(Unit) {
                viewModel.getMapDetail(mapId.orEmpty())
            }
            MapDetailScreen(
                uiState = uiState,
                uiEffect = uiEffect,
                onAction = viewModel::onAction,
                onBackClick = { navHostController.popBackStack() },
            )
        }
        composable(Routes.WEAPONS) {
            val viewModel: WeaponsViewModel = koinInject()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect
            LaunchedEffect(Unit) {
                viewModel.getWeapons()
            }
            WeaponsScreen(
                uiState = uiState,
                uiEffect = uiEffect,
                onAction = viewModel::onAction,
                onNavigateWeaponDetail = { weaponId ->
                    navHostController.navigate(Routes.WEAPON_DETAIL.plus("/$weaponId"))
                }
            )
        }
        composable(Routes.WEAPON_DETAIL_WITH_PARAM) { backStackEntry ->
            val weaponId = backStackEntry.arguments?.getString(Params.WEAPON_ID)
            val viewModel: WeaponDetailViewModel = koinInject()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect
            LaunchedEffect(Unit) {
                viewModel.getWeaponDetail(weaponId.orEmpty())
            }
            WeaponDetailScreen(
                uiState = uiState,
                uiEffect = uiEffect,
                onAction = viewModel::onAction,
                onBackClick = { navHostController.popBackStack() },
            )
        }
        composable(Routes.TIERS) {
            val viewModel: TiersViewModel = koinInject()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect
            LaunchedEffect(Unit) {
                viewModel.getTiers()
            }
            TiersScreen(
                uiState = uiState,
                uiEffect = uiEffect,
            )
        }
    }
}
