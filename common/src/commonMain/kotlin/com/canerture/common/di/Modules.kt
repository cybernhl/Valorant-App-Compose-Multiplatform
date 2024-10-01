package com.canerture.common.di

import com.canerture.common.data.remote.ValorantService
import com.canerture.common.data.repository.ValorantRepositoryImpl
import com.canerture.common.domain.repository.ValorantRepository
import com.canerture.common.domain.usecase.agents.GetAgentDetailUseCase
import com.canerture.common.domain.usecase.agents.GetAgentsUseCase
import com.canerture.common.domain.usecase.maps.GetMapDetailUseCase
import com.canerture.common.domain.usecase.maps.GetMapsUseCase
import com.canerture.common.domain.usecase.tiers.GetTiersUseCase
import com.canerture.common.domain.usecase.weapons.GetWeaponDetailUseCase
import com.canerture.common.domain.usecase.weapons.GetWeaponsUseCase
import com.canerture.common.presentation.agentdetail.AgentDetailViewModel
import com.canerture.common.presentation.agents.AgentsViewModel
import com.canerture.common.presentation.mapdetail.MapDetailViewModel
import com.canerture.common.presentation.maps.MapsViewModel
import com.canerture.common.presentation.tiers.TiersViewModel
import com.canerture.common.presentation.weapondetail.WeaponDetailViewModel
import com.canerture.common.presentation.weapons.WeaponsViewModel
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val dataModule = module {
    single<ValorantService> { ValorantService() }
    single<ValorantRepository> { ValorantRepositoryImpl(get()) }
}

val useCaseModule = module {
    factoryOf(::GetAgentsUseCase)
    factoryOf(::GetAgentDetailUseCase)
    factoryOf(::GetTiersUseCase)
    factoryOf(::GetMapsUseCase)
    factoryOf(::GetMapDetailUseCase)
    factoryOf(::GetWeaponsUseCase)
    factoryOf(::GetWeaponDetailUseCase)
}

val screenModelsModule = module {
    factoryOf(::AgentsViewModel)
    factoryOf(::AgentDetailViewModel)
    factoryOf(::TiersViewModel)
    factoryOf(::MapsViewModel)
    factoryOf(::MapDetailViewModel)
    factoryOf(::WeaponsViewModel)
    factoryOf(::WeaponDetailViewModel)
}
//FIXME Cannot access class 'org.koin.core.KoinApplication'. Check your module classpath for missing or conflicting dependencies.
fun initKoin() : Any = startKoin { modules(dataModule, useCaseModule, screenModelsModule) }
