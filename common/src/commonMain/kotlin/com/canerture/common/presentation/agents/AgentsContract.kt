package com.canerture.common.presentation.agents

import com.canerture.common.domain.model.AgentGroupUI

public object AgentsContract {
    public data class UiState(
        val isLoading: Boolean = false,
        val agents: List<AgentGroupUI> = emptyList(),
    )

    public sealed class UiAction {
        public data class OnAgentClick(val id: String) : UiAction()
    }

    public sealed class UiEffect {
        public data class GoToAgentDetail(val id: String) : UiEffect()
        public data class ShowError(val message: String) : UiEffect()
    }
}