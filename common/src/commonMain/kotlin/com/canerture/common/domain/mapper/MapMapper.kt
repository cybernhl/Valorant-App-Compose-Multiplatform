package com.canerture.common.domain.mapper

import com.canerture.common.domain.model.MapUI
import com.canerture.common.data.model.maps.Map

fun List<Map>?.mapToMapUI() = this?.map {
    MapUI(
        coordinates = it.coordinates.orEmpty(),
        displayIcon = it.displayIcon.orEmpty(),
        displayName = it.displayName.orEmpty(),
        narrativeDescription = it.narrativeDescription.orEmpty(),
        splash = it.splash.orEmpty(),
        listViewIconTall = it.listViewIconTall.orEmpty(),
        id = it.id.orEmpty()
    )
}.orEmpty()

fun Map?.mapToMapUI() = MapUI(
    coordinates = this?.coordinates.orEmpty(),
    displayIcon = this?.displayIcon.orEmpty(),
    displayName = this?.displayName.orEmpty(),
    narrativeDescription = this?.narrativeDescription.orEmpty(),
    splash = this?.splash.orEmpty(),
    listViewIconTall = this?.listViewIconTall.orEmpty(),
    id = this?.id.orEmpty()
)
