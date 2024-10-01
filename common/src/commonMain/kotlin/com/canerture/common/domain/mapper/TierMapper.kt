package com.canerture.common.domain.mapper

import com.canerture.common.data.model.competitivetiers.Tier
import com.canerture.common.domain.model.TierUI

fun List<Tier>?.mapToTierUI(): List<TierUI> = this?.map {
    TierUI(
        backgroundColor = it.backgroundColor.orEmpty(),
        color = it.color.orEmpty(),
        division = it.division.orEmpty(),
        divisionName = it.divisionName.orEmpty(),
        largeIcon = it.largeIcon.orEmpty(),
        smallIcon = it.smallIcon.orEmpty(),
        tier = it.tier ?: 0,
        tierName = it.tierName.orEmpty()
    )
}.orEmpty().filter { it.largeIcon.isNotEmpty() && it.tierName != "UNRANKED" }
