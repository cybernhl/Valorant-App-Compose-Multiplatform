package com.canerture.common.presentation.agentdetail

import com.canerture.common.domain.model.AgentUI

object AgentDetailContract {
    data class UiState(
        val isLoading: Boolean = false,
        val agent: AgentUI? = null,
    )

    sealed class UiAction {
        data object OnBackClick : UiAction()
    }

    sealed class UiEffect {
        data class ShowError(val message: String) : UiEffect()
        data object GoToBack : UiEffect()
    }
}