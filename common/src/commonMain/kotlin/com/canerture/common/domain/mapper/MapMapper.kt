package com.canerture.common.domain.mapper

import com.canerture.common.data.model.maps.Map
import com.canerture.common.domain.model.MapUI

public fun List<Map>?.mapToMapUI(): List<MapUI> = this?.map {
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

public fun Map?.mapToMapUI(): MapUI = MapUI(
    coordinates = this?.coordinates.orEmpty(),
    displayIcon = this?.displayIcon.orEmpty(),
    displayName = this?.displayName.orEmpty(),
    narrativeDescription = this?.narrativeDescription.orEmpty(),
    splash = this?.splash.orEmpty(),
    listViewIconTall = this?.listViewIconTall.orEmpty(),
    id = this?.id.orEmpty()
)
