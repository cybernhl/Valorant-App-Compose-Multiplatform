package com.canerture.common.presentation.maps

import com.canerture.common.domain.model.MapUI

public object MapsContract {
    public    data class UiState(
        val isLoading: Boolean = false,
        val maps: List<MapUI> = emptyList(),
    )

    public   sealed class UiAction {
        public data class OnMapClick(val id: String) : UiAction()
    }

    public  sealed class UiEffect {
        public   data class GoToMapDetail(val id: String) : UiEffect()
        public    data class ShowError(val message: String) : UiEffect()
    }
}