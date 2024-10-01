package com.canerture.common.data.model.agents

import kotlinx.serialization.Serializable

@Serializable
data class Role(
    val displayIcon: String?,
    val displayName: String?,
)
