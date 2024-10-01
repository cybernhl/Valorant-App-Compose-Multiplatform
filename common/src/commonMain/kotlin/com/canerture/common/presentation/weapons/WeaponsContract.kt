package com.canerture.common.presentation.weapons

import com.canerture.common.domain.model.WeaponUI

public object WeaponsContract {
    public data class UiState(
        val isLoading: Boolean = false,
        val weapons: List<WeaponUI> = emptyList(),
    )

    public sealed class UiAction {
        public data class OnWeaponClick(val id: String) : UiAction()
    }

    public sealed class UiEffect {
        public data class GoToWeaponDetail(val id: String) : UiEffect()
        public data class ShowError(val message: String) : UiEffect()
    }
}