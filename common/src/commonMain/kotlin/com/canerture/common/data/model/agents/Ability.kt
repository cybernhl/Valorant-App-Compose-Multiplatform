package com.canerture.common.data.model.agents

import kotlinx.serialization.Serializable

@Serializable
data class Ability(
    val description: String?,
    val displayIcon: String?,
    val displayName: String?,
    val slot: String?
)
