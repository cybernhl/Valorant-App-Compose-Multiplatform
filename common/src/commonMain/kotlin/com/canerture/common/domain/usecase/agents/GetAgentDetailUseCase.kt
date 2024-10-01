package com.canerture.common.domain.usecase.agents

import com.canerture.common.domain.mapper.mapToAgentUI
import com.canerture.common.domain.model.AgentUI
import com.canerture.common.domain.repository.ValorantRepository

class GetAgentDetailUseCase(
    private val valorantRepository: ValorantRepository
) {
    suspend operator fun invoke(id: String): Result<AgentUI> {
        return valorantRepository.getAgentDetail(id).map {
            it.mapToAgentUI()
        }
    }
}
