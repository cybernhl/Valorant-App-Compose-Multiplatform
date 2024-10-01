package com.canerture.common.presentation.tiers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.canerture.common.delegation.MVI
import com.canerture.common.delegation.mvi
import com.canerture.common.domain.usecase.tiers.GetTiersUseCase
import com.canerture.common.presentation.tiers.TiersContract.UiEffect
import com.canerture.common.presentation.tiers.TiersContract.UiState
import kotlinx.coroutines.launch

public class TiersViewModel(
    private val getTiersUseCase: GetTiersUseCase
) : ViewModel(), MVI<UiState, Unit, UiEffect> by mvi(UiState()) {

    public    fun getTiers() {
        viewModelScope.launch {
            updateUiState { copy(isLoading = true) }
            getTiersUseCase().onSuccess { list ->
                updateUiState { copy(isLoading = false, tiers = list) }
            }.onFailure {
                updateUiState { copy(isLoading = false) }
                emitUiEffect(UiEffect.ShowError(it.message.orEmpty()))
            }
        }
    }
}
