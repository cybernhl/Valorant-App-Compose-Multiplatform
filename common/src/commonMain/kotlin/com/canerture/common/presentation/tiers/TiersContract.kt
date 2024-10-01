package com.canerture.common.presentation.tiers

import com.canerture.common.domain.model.TierUI

public object TiersContract {
    public data class UiState(
        val isLoading: Boolean = false,
        val tiers: List<TierUI> = emptyList(),
    )

    public sealed class UiEffect {
        public data class ShowError(val message: String) : UiEffect()
    }
}