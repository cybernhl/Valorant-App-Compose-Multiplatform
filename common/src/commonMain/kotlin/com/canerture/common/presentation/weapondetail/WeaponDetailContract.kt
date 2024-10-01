package com.canerture.common.presentation.weapondetail

import com.canerture.common.domain.model.WeaponUI

public object WeaponDetailContract {
    public data class UiState(
        val isLoading: Boolean = false,
        val weapon: WeaponUI? = null,
    )

    public sealed class UiAction {
        public data object OnBackClick : UiAction()
    }

    public sealed class UiEffect {
        public data object GoToBack : UiEffect()
        public data class ShowError(val message: String) : UiEffect()
    }
}