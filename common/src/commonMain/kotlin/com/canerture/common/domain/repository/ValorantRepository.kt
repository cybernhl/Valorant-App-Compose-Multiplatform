package com.canerture.common.domain.repository

import com.canerture.common.data.model.agents.Agent
import com.canerture.common.data.model.competitivetiers.CompetitiveTier
import com.canerture.common.data.model.maps.Map
import com.canerture.common.data.model.weapons.Weapon

public interface ValorantRepository {
    public suspend fun getAgents(): Result<List<Agent>?>
    public suspend fun getAgentDetail(id: String): Result<Agent?>
    public suspend fun getMaps(): Result<List<Map>?>
    public suspend fun getMapDetail(id: String): Result<Map?>
    public suspend fun getWeapons(): Result<List<Weapon>?>
    public suspend fun getWeaponDetail(id: String): Result<Weapon?>
    public suspend fun getTiers(): Result<List<CompetitiveTier>?>
}
