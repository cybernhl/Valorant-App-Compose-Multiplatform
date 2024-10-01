package com.canerture.common.domain.model

import androidx.compose.ui.graphics.Color

public data class AgentGroupUI(
    val role: String,
    val roleIcon: String,
    val agents: List<AgentUI>
)

public data class AgentUI(
    val abilities: List<AbilityUI>,
    val description: String,
    val displayName: String,
    val fullPortrait: String,
    val role: RoleUI,
    val id: String,
    val background: String,
    val backgroundGradientColors: List<Color>,
)

public data class AbilityUI(
    val description: String,
    val displayIcon: String,
    val displayName: String,
)

public data class RoleUI(
    val displayIcon: String,
    val displayName: String
)
