package com.canerture.common.presentation.weapondetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.canerture.common.delegation.MVI
import com.canerture.common.delegation.mvi
import com.canerture.common.domain.usecase.weapons.GetWeaponDetailUseCase
import com.canerture.common.presentation.weapondetail.WeaponDetailContract.UiAction
import com.canerture.common.presentation.weapondetail.WeaponDetailContract.UiEffect
import com.canerture.common.presentation.weapondetail.WeaponDetailContract.UiState
import kotlinx.coroutines.launch

public class WeaponDetailViewModel(
    private val getWeaponDetailUseCase: GetWeaponDetailUseCase,
) : ViewModel(), MVI<UiState, UiAction, UiEffect> by mvi(UiState()) {

    override fun onAction(uiAction: UiAction) {
        viewModelScope.launch {
            when (uiAction) {
                is UiAction.OnBackClick -> emitUiEffect(UiEffect.GoToBack)
            }
        }
    }

    public fun getWeaponDetail(id: String) {
        viewModelScope.launch {
            updateUiState { copy(weapon = null) }
            getWeaponDetailUseCase(id).onSuccess {
                updateUiState { copy(isLoading = false, weapon = it) }
            }.onFailure {
                updateUiState { copy(isLoading = false) }
                emitUiEffect(UiEffect.ShowError(it.message.orEmpty()))
            }
        }
    }
}