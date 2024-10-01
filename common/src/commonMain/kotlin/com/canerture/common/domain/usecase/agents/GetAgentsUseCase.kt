package com.canerture.common.domain.usecase.agents

import com.canerture.common.domain.mapper.mapToAgentRoleUI
import com.canerture.common.domain.model.AgentGroupUI
import com.canerture.common.domain.repository.ValorantRepository

class GetAgentsUseCase(
    private val valorantRepository: ValorantRepository
) {
    suspend operator fun invoke(): Result<List<AgentGroupUI>> {
        return valorantRepository.getAgents().map {
            it.mapToAgentRoleUI()
        }
    }
}
