package com.canerture.common.presentation.tiers

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.canerture.common.common.collectWithLifecycle
import com.canerture.common.domain.model.TierUI
import com.canerture.common.presentation.components.ValorantProgressBar
import kotlinx.coroutines.flow.Flow

@Composable
public fun TiersScreen(
    uiState: TiersContract.UiState,
    uiEffect: Flow<TiersContract.UiEffect>,
) {
    uiEffect.collectWithLifecycle { effect ->
        when (effect) {
            is TiersContract.UiEffect.ShowError -> {

            }
        }
    }

    TierListContent(
        tiers = uiState.tiers
    )

    if (uiState.isLoading) ValorantProgressBar()
}

@Composable
public fun TierListContent(
    tiers: List<TierUI>
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(180.dp),
        contentPadding = PaddingValues(12.dp)
    ) {
        items(tiers) { tierItem ->
            CompetitiveTierItem(
                tier = tierItem
            )
        }
    }
}
