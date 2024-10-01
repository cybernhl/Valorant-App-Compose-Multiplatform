package com.canerture.common.domain.model

public data class WeaponUI(
    val category: String,
    val displayIcon: String,
    val displayName: String,
    var skins: List<SkinUI>,
    val id: String,
    val weaponStats: WeaponStatsUI
)

public data class SkinUI(
    val displayIcon: String,
    val displayName: String,
)

public data class WeaponStatsUI(
    val damageRanges: List<DamageRangeUI>,
)

public data class DamageRangeUI(
    val rangeStartMeters: Int,
    val rangeEndMeters: Int,
    val bodyDamage: Double,
    val headDamage: Double,
    val legDamage: Double,
)
