package com.canerture.common.data.model.weapons

import com.canerture.common.data.model.weapons.DamageRange
import kotlinx.serialization.Serializable

@Serializable
data class WeaponStats(
    val damageRanges: List<DamageRange>?,
)
