package com.canerture.common.presentation.maps

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.canerture.common.delegation.MVI
import com.canerture.common.delegation.mvi
import com.canerture.common.domain.usecase.maps.GetMapsUseCase
import com.canerture.common.presentation.maps.MapsContract.UiAction
import com.canerture.common.presentation.maps.MapsContract.UiEffect
import com.canerture.common.presentation.maps.MapsContract.UiState
import kotlinx.coroutines.launch

public class MapsViewModel(
    private val getMapsUseCase: GetMapsUseCase
) : ViewModel(), MVI<UiState, UiAction, UiEffect> by mvi(UiState()) {

    override fun onAction(uiAction: UiAction) {
        viewModelScope.launch {
            when (uiAction) {
                is UiAction.OnMapClick -> emitUiEffect(UiEffect.GoToMapDetail(uiAction.id))
            }
        }
    }

    public fun getMaps() {
        viewModelScope.launch {
            updateUiState { copy(isLoading = true) }
            getMapsUseCase().onSuccess {
                emitUiEffect(UiEffect.ShowError("it.message.orEmpty()"))
            }.onFailure {
                updateUiState { copy(isLoading = false) }
                emitUiEffect(UiEffect.ShowError(it.message.orEmpty()))
            }
        }
    }
}
