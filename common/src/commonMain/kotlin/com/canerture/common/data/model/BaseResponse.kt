package com.canerture.common.data.model

import kotlinx.serialization.Serializable

@Serializable
public open class BaseResponse<T>(
    public val status: Int? = null,
    public val error: String? = null,
    public val data: T? = null,
)
