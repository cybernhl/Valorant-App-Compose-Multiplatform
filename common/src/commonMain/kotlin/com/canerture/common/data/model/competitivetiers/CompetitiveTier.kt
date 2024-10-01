package com.canerture.common.data.model.competitivetiers

import kotlinx.serialization.Serializable

@Serializable
public data class CompetitiveTier(
    val tiers: List<Tier>?,
)
