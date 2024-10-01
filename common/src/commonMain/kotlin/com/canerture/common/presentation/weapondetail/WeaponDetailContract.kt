package com.canerture.common.presentation.weapondetail

import com.canerture.common.domain.model.WeaponUI

object WeaponDetailContract {
    data class UiState(
        val isLoading: Boolean = false,
        val weapon: WeaponUI? = null,
    )

    sealed class UiAction {
        data object OnBackClick : UiAction()
    }

    sealed class UiEffect {
        data object GoToBack : UiEffect()
        data class ShowError(val message: String) : UiEffect()
    }
}