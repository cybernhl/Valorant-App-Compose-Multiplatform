package com.canerture.common.data.model.maps

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Map(
    val coordinates: String?,
    val displayIcon: String?,
    val displayName: String?,
    val narrativeDescription: String?,
    val splash: String?,
    val listViewIconTall: String?,
    @SerialName("uuid") val id: String?,
)
