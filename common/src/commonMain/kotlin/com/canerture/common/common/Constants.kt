package com.canerture.common.common

public object Routes {
    public    const val SPLASH: String = "splash"
    public    const val AGENTS : String ="agents"
    public    const val AGENT_DETAIL : String = "agentDetail"
    public    const val AGENT_DETAIL_WITH_PARAM : String = "agentDetail/{agentId}"
    public   const val MAPS : String = "maps"
    public   const val MAP_DETAIL : String = "mapDetail"
    public   const val MAP_DETAIL_WITH_PARAM : String ="mapDetail/{mapId}"
    public  const val WEAPONS : String ="weapons"
    public  const val WEAPON_DETAIL : String = "weaponDetail"
    public  const val WEAPON_DETAIL_WITH_PARAM : String = "weaponDetail/{weaponId}"
    public  const val TIERS : String ="tiers"
}

public object Params {
    public const val AGENT_ID : String = "agentId"
    public  const val MAP_ID : String = "mapId"
    public  const val WEAPON_ID : String = "weaponId"
}

public object Endpoints {
    public  const val AGENTS : String = "v1/agents?isPlayableCharacter=true"
    public  const val AGENT_DETAIL: String ="v1/agents"
    public  const val MAPS : String = "v1/maps"
    public  const val WEAPONS : String = "v1/weapons"
    public   const val TIERS : String ="v1/competitivetiers"
}