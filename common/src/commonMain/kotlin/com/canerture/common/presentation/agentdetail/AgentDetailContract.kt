package com.canerture.common.presentation.agentdetail

import com.canerture.common.domain.model.AgentUI

public object AgentDetailContract {
    public data class UiState(
        val isLoading: Boolean = false,
        val agent: AgentUI? = null,
    )

    public sealed class UiAction {
        public data object OnBackClick : UiAction()
    }

    public sealed class UiEffect {
        public data class ShowError(val message: String) : UiEffect()
        public data object GoToBack : UiEffect()
    }
}