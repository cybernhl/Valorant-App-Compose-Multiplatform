package com.canerture.common.domain.usecase.weapons

import com.canerture.common.domain.mapper.mapToWeaponUI
import com.canerture.common.domain.model.WeaponUI
import com.canerture.common.domain.repository.ValorantRepository

class GetWeaponDetailUseCase(
    private val valorantRepository: ValorantRepository
) {
    suspend operator fun invoke(id: String): Result<WeaponUI> {
        return valorantRepository.getWeaponDetail(id).map {
            it.mapToWeaponUI()
        }
    }
}
