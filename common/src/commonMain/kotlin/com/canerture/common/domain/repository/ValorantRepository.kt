package com.canerture.common.domain.repository

import com.canerture.common.data.model.agents.Agent
import com.canerture.common.data.model.competitivetiers.CompetitiveTier
import com.canerture.common.data.model.weapons.Weapon
import com.canerture.common.data.model.maps.Map

interface ValorantRepository {
    suspend fun getAgents(): Result<List<Agent>?>
    suspend fun getAgentDetail(id: String): Result<Agent?>
    suspend fun getMaps(): Result<List<Map>?>
    suspend fun getMapDetail(id: String): Result<Map?>
    suspend fun getWeapons(): Result<List<Weapon>?>
    suspend fun getWeaponDetail(id: String): Result<Weapon?>
    suspend fun getTiers(): Result<List<CompetitiveTier>?>
}
