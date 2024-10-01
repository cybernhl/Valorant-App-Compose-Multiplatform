package com.canerture.common.domain.mapper

import com.canerture.common.data.model.weapons.DamageRange
import com.canerture.common.data.model.weapons.Skin
import com.canerture.common.data.model.weapons.Weapon
import com.canerture.common.data.model.weapons.WeaponStats
import com.canerture.common.domain.model.DamageRangeUI
import com.canerture.common.domain.model.SkinUI
import com.canerture.common.domain.model.WeaponStatsUI
import com.canerture.common.domain.model.WeaponUI

public fun List<Weapon>?.mapToWeaponUI(): List<WeaponUI> = this?.map {
    WeaponUI(
        category = it.category.orEmpty().replace("EEquippableCategory::", ""),
        displayIcon = it.displayIcon.orEmpty(),
        displayName = it.displayName.orEmpty(),
        skins = it.skins.mapToSkinUI(),
        id = it.id.orEmpty(),
        weaponStats = it.weaponStats.mapToWeaponStatsUI()
    )
}.orEmpty()

public fun Weapon?.mapToWeaponUI(): WeaponUI = WeaponUI(
    category = this?.category.orEmpty().replace("EEquippableCategory::", ""),
    displayIcon = this?.displayIcon.orEmpty(),
    displayName = this?.displayName.orEmpty(),
    skins = this?.skins.mapToSkinUI(),
    id = this?.id.orEmpty(),
    weaponStats = this?.weaponStats.mapToWeaponStatsUI()
)

public fun WeaponStats?.mapToWeaponStatsUI(): WeaponStatsUI = WeaponStatsUI(
    damageRanges = this?.damageRanges.mapToDamageRangeUI(),
)

public fun List<Skin>?.mapToSkinUI(): List<SkinUI> = this?.map {
    SkinUI(
        displayIcon = it.displayIcon.orEmpty(),
        displayName = it.displayName.orEmpty(),
    )
}.orEmpty().filter { it.displayIcon.isNotEmpty() }

public fun List<DamageRange>?.mapToDamageRangeUI(): List<DamageRangeUI> = this?.map {
    DamageRangeUI(
        rangeStartMeters = it.rangeStartMeters ?: 0,
        rangeEndMeters = it.rangeEndMeters ?: 0,
        bodyDamage = it.bodyDamage ?: 0.0,
        headDamage = it.headDamage ?: 0.0,
        legDamage = it.legDamage ?: 0.0,
    )
}.orEmpty()
