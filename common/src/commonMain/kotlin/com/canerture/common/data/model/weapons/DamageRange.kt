package com.canerture.common.data.model.weapons

import kotlinx.serialization.Serializable

@Serializable
public data class DamageRange(
    val rangeStartMeters: Int?,
    val rangeEndMeters: Int?,
    val bodyDamage: Double?,
    val headDamage: Double?,
    val legDamage: Double?,
)
