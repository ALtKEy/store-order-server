package com.altkey.code.store.order.spring

import com.altkey.code.common.exception.CodeException
import com.altkey.code.common.exception.CodeRuntimeException
import com.altkey.code.common.utils.EnumUtils
import com.altkey.code.context.response.ErrorResponse
import com.altkey.code.store.order.exception.StoreOrderError
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

/**
 * Exception Handler
 *
 * @author Kim Jung-tae(altkey)
 * @since 2025-04-07
 */
@RestControllerAdvice
class StoreOrderExceptionHandler {
    //
    private val logger = KotlinLogging.logger {}

    @ExceptionHandler(CodeRuntimeException::class)
    fun exceptionHandler(exception: CodeRuntimeException): ResponseEntity<ErrorResponse> {
        val message: String? = exception.message

        logger.info { "CodeRuntimeException [ code : ${EnumUtils.codeEnum(StoreOrderError::class.java, exception.getErrorCode())}(${exception.getErrorCode()}) / class_name : ${exception.stackTrace[0].className} / message : $message ]" }
        return ResponseEntity<ErrorResponse>(
            ErrorResponse(
                code = exception.getErrorCode(),
                message = if(message.isNullOrEmpty()) "ERROR" else message
            ),
            HttpStatus.INTERNAL_SERVER_ERROR
        )
    }

    @ExceptionHandler(CodeException::class)
    fun exceptionHandler(exception: CodeException): ResponseEntity<ErrorResponse> {
        val message: String? = exception.message

        logger.info { "CodeException [ code : ${EnumUtils.codeEnum(StoreOrderError::class.java, exception.getErrorCode())}(${exception.getErrorCode()}) / class_name : ${exception.stackTrace[0].className} / message : $message ]" }
        return ResponseEntity<ErrorResponse>(
            ErrorResponse(
                code = exception.getErrorCode(),
                message = if(message.isNullOrEmpty()) "ERROR" else message
            ),
            HttpStatus.INTERNAL_SERVER_ERROR
        )
    }
}