package com.canerture.common.data.remote

//import com.canerture.valorantcmp.BuildKonfig
import com.canerture.common.common.Endpoints
import com.canerture.common.data.model.BaseResponse
import com.canerture.common.data.model.agents.Agent
import com.canerture.common.data.model.competitivetiers.CompetitiveTier
import com.canerture.common.data.model.maps.Map
import com.canerture.common.data.model.weapons.Weapon
import com.canerture.common.data.remote.KtorApi
import io.ktor.client.call.body
import io.ktor.client.request.get

public class ValorantService : KtorApi() {

    private val baseUrl = "BuildKonfig.BASE_URL"

    public suspend fun getAgents(): BaseResponse<List<Agent>> {
        return client.get(baseUrl.plus(Endpoints.AGENTS)).body<BaseResponse<List<Agent>>>()
    }

    public  suspend fun getMaps(): BaseResponse<List<Map>> {
        return client.get(baseUrl.plus(Endpoints.MAPS)).body<BaseResponse<List<Map>>>()
    }

    public  suspend fun getWeapons(): BaseResponse<List<Weapon>> {
        return client.get(baseUrl.plus(Endpoints.WEAPONS)).body<BaseResponse<List<Weapon>>>()
    }

    public suspend fun getTiers(): BaseResponse<List<CompetitiveTier>> {
        return client.get(baseUrl.plus(Endpoints.TIERS)).body<BaseResponse<List<CompetitiveTier>>>()
    }

    public  suspend fun getAgentDetail(id: String): BaseResponse<Agent> {
        return client.get(baseUrl.plus(Endpoints.AGENT_DETAIL.plus("/$id"))).body<BaseResponse<Agent>>()
    }

    public  suspend fun getMapDetail(id: String): BaseResponse<Map> {
        return client.get(baseUrl.plus(Endpoints.MAPS.plus("/$id"))).body<BaseResponse<Map>>()
    }

    public suspend fun getWeaponDetail(id: String): BaseResponse<Weapon> {
        return client.get(baseUrl.plus(Endpoints.WEAPONS.plus("/$id"))).body<BaseResponse<Weapon>>()
    }
}
