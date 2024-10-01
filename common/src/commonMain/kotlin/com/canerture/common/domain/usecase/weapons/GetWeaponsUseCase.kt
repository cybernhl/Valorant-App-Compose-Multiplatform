package com.canerture.common.domain.usecase.weapons

import com.canerture.common.domain.mapper.mapToWeaponUI
import com.canerture.common.domain.model.WeaponUI
import com.canerture.common.domain.repository.ValorantRepository

public class GetWeaponsUseCase(
    private val valorantRepository: ValorantRepository
) {
    public suspend operator fun invoke(): Result<List<WeaponUI>> {
        return valorantRepository.getWeapons().map {
            it.mapToWeaponUI()
        }
    }
}
