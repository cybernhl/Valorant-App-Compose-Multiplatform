package com.canerture.common.delegation

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

public interface MVI<UiState, UiAction, UiEffect> {
    public val uiState: StateFlow<UiState>

    public val uiEffect: Flow<UiEffect>

    public fun onAction(uiAction: UiAction)

    public fun updateUiState(block: UiState.() -> UiState)

    public suspend fun emitUiEffect(uiEffect: UiEffect)
}

public fun <UiState, UiAction, UiEffect> mvi(
    initialState: UiState,
): MVI<UiState, UiAction, UiEffect> = MVIDelegate(initialState)