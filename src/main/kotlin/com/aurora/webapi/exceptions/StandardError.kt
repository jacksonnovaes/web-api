package com.aurora.webapi.exceptions

data class StandardError(

    val status: Int? = null,

    val msg: String? = null,

    val timaStamp: Long? = null,

    val uri: String? = null
)
