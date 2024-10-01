package com.canerture.common.presentation.mapdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.canerture.common.delegation.MVI
import com.canerture.common.delegation.mvi
import com.canerture.common.domain.usecase.maps.GetMapDetailUseCase
import com.canerture.common.presentation.mapdetail.MapDetailContract.UiAction
import com.canerture.common.presentation.mapdetail.MapDetailContract.UiEffect
import com.canerture.common.presentation.mapdetail.MapDetailContract.UiState
import kotlinx.coroutines.launch

public class MapDetailViewModel(
    private val getMapDetailUseCase: GetMapDetailUseCase,
) : ViewModel(), MVI<UiState, UiAction, UiEffect> by mvi(UiState()) {

    override fun onAction(uiAction: UiAction) {
        viewModelScope.launch {
            when (uiAction) {
                is UiAction.OnBackClick -> emitUiEffect(UiEffect.GoToBack)
            }
        }
    }

    public fun getMapDetail(id: String) {
        viewModelScope.launch {
            updateUiState { copy(isLoading = true) }
            getMapDetailUseCase(id).onSuccess {
                updateUiState { copy(isLoading = false, map = it) }
            }.onFailure {
                updateUiState { copy(isLoading = false) }
                emitUiEffect(UiEffect.ShowError(it.message.orEmpty()))
            }
        }
    }
}