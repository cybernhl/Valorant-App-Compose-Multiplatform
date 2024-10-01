package com.canerture.common.presentation.agentdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.canerture.common.delegation.MVI
import com.canerture.common.delegation.mvi
import com.canerture.common.domain.usecase.agents.GetAgentDetailUseCase
import com.canerture.common.presentation.agentdetail.AgentDetailContract.UiAction
import com.canerture.common.presentation.agentdetail.AgentDetailContract.UiEffect
import com.canerture.common.presentation.agentdetail.AgentDetailContract.UiState
import kotlinx.coroutines.launch

public class AgentDetailViewModel(
    private val getAgentDetailUseCase: GetAgentDetailUseCase,
) : ViewModel(), MVI<UiState, UiAction, UiEffect> by mvi(UiState()) {

    override fun onAction(uiAction: UiAction) {
        viewModelScope.launch {
            when (uiAction) {
                is UiAction.OnBackClick -> emitUiEffect(UiEffect.GoToBack)
            }
        }
    }

    public fun getAgentDetail(id: String) {
        viewModelScope.launch {
            updateUiState { copy(isLoading = true) }
            getAgentDetailUseCase(id).onSuccess {
                updateUiState { copy(isLoading = false, agent = it) }
            }.onFailure {
                updateUiState { copy(isLoading = false) }
                emitUiEffect(UiEffect.ShowError(it.message.orEmpty()))
            }
        }
    }
}
