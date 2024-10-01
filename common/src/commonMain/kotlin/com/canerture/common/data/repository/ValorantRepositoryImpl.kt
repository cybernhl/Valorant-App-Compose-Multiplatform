package com.canerture.common.data.repository

import com.canerture.common.data.model.BaseResponse
import com.canerture.common.data.model.agents.Agent
import com.canerture.common.data.model.competitivetiers.CompetitiveTier
import com.canerture.common.data.model.maps.Map
import com.canerture.common.data.model.weapons.Weapon
import com.canerture.common.data.remote.ValorantService
import com.canerture.common.domain.repository.ValorantRepository

public class ValorantRepositoryImpl(private val valorantService: ValorantService) :
    ValorantRepository {

    override suspend fun getAgents(): Result<List<Agent>?> = safeApiCall {
        valorantService.getAgents()
    }

    override suspend fun getAgentDetail(id: String): Result<Agent?> = safeApiCall {
        valorantService.getAgentDetail(id)
    }

    override suspend fun getMaps(): Result<List<Map>?> = safeApiCall {
        valorantService.getMaps()
    }

    override suspend fun getMapDetail(id: String): Result<Map?> = safeApiCall {
        valorantService.getMapDetail(id)
    }

    override suspend fun getWeapons(): Result<List<Weapon>?> = safeApiCall {
        valorantService.getWeapons()
    }

    override suspend fun getWeaponDetail(id: String): Result<Weapon?> = safeApiCall {
        valorantService.getWeaponDetail(id)
    }

    override suspend fun getTiers(): Result<List<CompetitiveTier>?> = safeApiCall {
        valorantService.getTiers()
    }

    private suspend fun <T : Any> safeApiCall(call: suspend () -> BaseResponse<T>): Result<T?> {
        return try {
            val response = call()
            if (response.status == SUCCESS) {
                Result.success(response.data)
            } else {
                Result.failure(Exception(response.error.toString()))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    public companion object {
        private const val SUCCESS = 200
    }
}
