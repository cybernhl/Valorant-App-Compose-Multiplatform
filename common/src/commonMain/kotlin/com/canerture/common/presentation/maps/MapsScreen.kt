package com.canerture.common.presentation.maps

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import com.canerture.common.Notify
import com.canerture.common.common.collectWithLifecycle
import com.canerture.common.domain.model.MapUI
import com.canerture.common.presentation.components.ValorantEmptyScreen
import com.canerture.common.presentation.components.ValorantProgressBar
import kotlinx.coroutines.flow.Flow

@Composable
fun MapsScreen(
    uiState: MapsContract.UiState,
    uiEffect: Flow<MapsContract.UiEffect>,
    onAction: (MapsContract.UiAction) -> Unit,
    onNavigateMapDetail: (String) -> Unit
) {
    var notifyShow by remember { mutableStateOf(false) }

    uiEffect.collectWithLifecycle { effect ->
        when (effect) {
            is MapsContract.UiEffect.GoToMapDetail -> onNavigateMapDetail(effect.id)
            is MapsContract.UiEffect.ShowError -> notifyShow = true
        }
    }

    if (notifyShow) {
        Notify("Please try again later!") {
            notifyShow = false
        }
    }

    when {
        uiState.isLoading -> ValorantProgressBar()
        uiState.maps.isEmpty() -> ValorantEmptyScreen()
        else -> MapListContent(
            maps = uiState.maps,
            onMapClick = { id ->
                onAction(MapsContract.UiAction.OnMapClick(id))
            }
        )
    }
}

@Composable
fun MapListContent(
    maps: List<MapUI>,
    onMapClick: (String) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(180.dp),
        contentPadding = PaddingValues(12.dp),
        verticalArrangement = Arrangement.Center
    ) {
        items(maps) { mapItem ->
            MapItem(
                map = mapItem,
                onMapClick = onMapClick
            )
        }
    }
}
