package com.canerture.common.domain.mapper

import com.canerture.common.common.colorParse
import com.canerture.common.data.model.agents.Ability
import com.canerture.common.data.model.agents.Agent
import com.canerture.common.data.model.agents.Role
import com.canerture.common.domain.model.AbilityUI
import com.canerture.common.domain.model.AgentGroupUI
import com.canerture.common.domain.model.AgentUI
import com.canerture.common.domain.model.RoleUI

public fun List<Agent>?.mapToAgentRoleUI(): List<AgentGroupUI> {
    val agents = this?.mapToAgentUI().orEmpty()
    return agents.groupBy { it.role.displayName }.map {
        AgentGroupUI(
            role = it.key,
            roleIcon = it.value.first().role.displayIcon,
            agents = it.value
        )
    }
}

public fun List<Agent>?.mapToAgentUI(): List<AgentUI> = this?.map { agent ->
    AgentUI(
        abilities = agent.abilities.mapToAbilityUI(),
        description = agent.description.orEmpty(),
        displayName = agent.displayName.orEmpty().uppercase(),
        fullPortrait = agent.fullPortraitV2 ?: agent.fullPortrait.orEmpty(),
        role = agent.role.mapToRoleUI(),
        id = agent.id.orEmpty(),
        background = agent.background.orEmpty(),
        backgroundGradientColors = agent.backgroundGradientColors.orEmpty().take(2).map { colorParse(it) }
    )
}.orEmpty()

public fun Agent?.mapToAgentUI(): AgentUI = AgentUI(
    abilities = this?.abilities.mapToAbilityUI(),
    description = this?.description.orEmpty(),
    displayName = this?.displayName.orEmpty().uppercase(),
    fullPortrait = this?.fullPortraitV2 ?: this?.fullPortrait.orEmpty(),
    role = this?.role.mapToRoleUI(),
    id = this?.id.orEmpty(),
    background = this?.background.orEmpty(),
    backgroundGradientColors = this?.backgroundGradientColors.orEmpty().take(2).map { colorParse(it) }
)

public fun Role?.mapToRoleUI(): RoleUI = RoleUI(
    displayIcon = this?.displayIcon.orEmpty(),
    displayName = this?.displayName.orEmpty()
)

public fun List<Ability>?.mapToAbilityUI(): List<AbilityUI> = this?.map {
    AbilityUI(
        description = it.description.orEmpty(),
        displayIcon = it.displayIcon.orEmpty(),
        displayName = it.displayName.orEmpty(),
    )
}.orEmpty()
