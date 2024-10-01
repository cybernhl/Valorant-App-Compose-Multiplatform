package com.canerture.common.domain.usecase.maps

import com.canerture.common.domain.mapper.mapToMapUI
import com.canerture.common.domain.model.MapUI
import com.canerture.common.domain.repository.ValorantRepository

class GetMapsUseCase(
    private val valorantRepository: ValorantRepository
) {
    suspend operator fun invoke(): Result<List<MapUI>> {
        return valorantRepository.getMaps().map {
            it.mapToMapUI()
        }
    }
}
