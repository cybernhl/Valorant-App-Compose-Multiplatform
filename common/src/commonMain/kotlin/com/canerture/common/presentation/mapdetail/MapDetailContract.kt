package com.canerture.common.presentation.mapdetail

import com.canerture.common.domain.model.MapUI

public object MapDetailContract {
    public data class UiState(
        val isLoading: Boolean = false,
        val map: MapUI? = null,
    )

    public sealed class UiAction {
        public data object OnBackClick : UiAction()
    }

    public sealed class UiEffect {
        public data object GoToBack : UiEffect()
        public data class ShowError(val message: String) : UiEffect()
    }
}