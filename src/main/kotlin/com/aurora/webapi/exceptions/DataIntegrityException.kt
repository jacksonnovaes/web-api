package com.aurora.webapi.exceptions;

class DataIntegrityException : RuntimeException {

    constructor(message: String) : super(message)

    constructor (message: String, cause: Throwable?) :
            super(message, cause);

    constructor (message: String, cause: Throwable, enableSuppression: Boolean, writableStackTrace: Boolean) :
            super(message, cause, enableSuppression, writableStackTrace);

}
