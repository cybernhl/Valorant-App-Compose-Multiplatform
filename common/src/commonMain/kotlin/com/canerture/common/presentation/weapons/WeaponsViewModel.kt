package com.canerture.common.presentation.weapons

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.canerture.common.delegation.MVI
import com.canerture.common.delegation.mvi
import com.canerture.common.domain.usecase.weapons.GetWeaponsUseCase
import com.canerture.common.presentation.weapons.WeaponsContract.UiAction
import com.canerture.common.presentation.weapons.WeaponsContract.UiEffect
import com.canerture.common.presentation.weapons.WeaponsContract.UiState
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

public class WeaponsViewModel(
    private val getWeaponsUseCase: GetWeaponsUseCase
) : ViewModel(), MVI<UiState, UiAction, UiEffect> by mvi(UiState()) {

    override fun onAction(uiAction: UiAction) {
        viewModelScope.launch {
            when (uiAction) {
                is UiAction.OnWeaponClick -> emitUiEffect(UiEffect.GoToWeaponDetail(uiAction.id))
            }
        }
    }

    public fun getWeapons(): Job = viewModelScope.launch {
        updateUiState { copy(isLoading = true) }
        getWeaponsUseCase().onSuccess {
            updateUiState { copy(isLoading = false, weapons = it) }
        }.onFailure {
            updateUiState { copy(isLoading = false) }
            emitUiEffect(UiEffect.ShowError(it.message.orEmpty()))
        }
    }
}