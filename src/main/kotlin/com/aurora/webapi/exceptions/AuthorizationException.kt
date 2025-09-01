package com.aurora.webapi.exceptions

class AuthorizationException: RuntimeException {

    constructor(message: String): super(message)

    constructor(message: String, cause: Throwable): super(message)

    constructor (message: String, cause: Throwable, enableSuppression: Boolean, writableStackTrace: Boolean) :
            super(message, cause, enableSuppression, writableStackTrace);

}