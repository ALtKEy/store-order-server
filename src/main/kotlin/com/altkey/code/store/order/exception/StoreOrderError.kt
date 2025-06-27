package com.altkey.code.store.order.exception

import com.altkey.code.context.enums.CodeEnum

/**
 *
 * @author Kim Jung-tae(altkey)
 * @since 2025-06-27
 */
enum class StoreOrderError(private val code: Long, private val description: String) : CodeEnum {
    CONTINUE(100, "Continue"),
    SWITCHING_PROTOCOLS(101, "Switching Protocols"),
    OK(200, "OK"),
    CREATED(201, "Created"),
    ACCEPTED(202, "Accepted"),
    MULTIPLE_CHOICES(300, "Multiple Choices"),
    MOVED_PERMANENTLY(301, "Moved Permanently"),
    FOUND(302, "Found"),
    BAD_REQUEST(400, "Bad Request"),
    UNAUTHORIZED(401, "Unauthorized"),
    FORBIDDEN(403, "Forbidden"),
    NOT_FOUND(404, "Not Found"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    NOT_IMPLEMENTED(501, "Not Implemented"),
    BAD_GATEWAY(502, "Bad Gateway"),
    UNKNOWN(-1, "Unknown Status")
    ;

    override fun getCode(): Long {
        return this.code
    }

    fun getDescription(): String? {
        return description
    }
}