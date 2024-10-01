package com.canerture.common.domain.usecase.maps

import com.canerture.common.domain.mapper.mapToMapUI
import com.canerture.common.domain.model.MapUI
import com.canerture.common.domain.repository.ValorantRepository

public class GetMapDetailUseCase(
    private val valorantRepository: ValorantRepository
) {
    public suspend operator fun invoke(id: String): Result<MapUI> {
        return valorantRepository.getMapDetail(id).map {
            it.mapToMapUI()
        }
    }
}
