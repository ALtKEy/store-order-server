package com.altkey.code.common.exception

import com.altkey.code.context.enums.CodeEnum

/**
 *
 * @author Kim Jung-tae(altkey)
 * @since 2025-06-22
 */
class CodeException : Exception {
    //
    private val errorCode: Long

    constructor() : super() {
        this.errorCode = CommonError.INTERNAL_SERVER_ERROR.getCode()
    }

    constructor(message: String?) : super(message) {
        this.errorCode = CommonError.INTERNAL_SERVER_ERROR.getCode()
    }

    constructor(error: CodeEnum, message: String?) : super(message) {
        this.errorCode = error.getCode()
    }

    constructor(message: String?, cause: Throwable?) : super(message, cause) {
        this.errorCode = CommonError.INTERNAL_SERVER_ERROR.getCode()
    }

    constructor(error: CodeEnum, message: String?, cause: Throwable?) : super(message, cause) {
        this.errorCode = error.getCode()
    }

    constructor(cause: Throwable?) : super(cause) {
        this.errorCode = CommonError.INTERNAL_SERVER_ERROR.getCode()
    }

    constructor(cause: CodeException) : super(cause.cause) {
        this.errorCode = cause.getErrorCode()
    }

    constructor(error: CodeEnum, cause: Throwable?) : super(cause) {
        this.errorCode = error.getCode()
    }

    fun getErrorCode(): Long {
        return this.errorCode
    }
}