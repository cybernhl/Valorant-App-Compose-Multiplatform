package com.canerture.common.domain.usecase.tiers

import com.canerture.common.domain.mapper.mapToTierUI
import com.canerture.common.domain.model.TierUI
import com.canerture.common.domain.repository.ValorantRepository

public class GetTiersUseCase(
    private val valorantRepository: ValorantRepository
) {
    public suspend operator fun invoke(): Result<List<TierUI>> {
        return valorantRepository.getTiers().map {
            it?.last()?.tiers.mapToTierUI()
        }
    }
}
