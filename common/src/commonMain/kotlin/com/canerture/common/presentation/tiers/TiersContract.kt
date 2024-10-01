package com.canerture.common.presentation.tiers

import com.canerture.common.domain.model.TierUI

object TiersContract {
    data class UiState(
        val isLoading: Boolean = false,
        val tiers: List<TierUI> = emptyList(),
    )

    sealed class UiEffect {
        data class ShowError(val message: String) : UiEffect()
    }
}