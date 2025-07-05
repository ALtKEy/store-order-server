package com.altkey.code.context.store.order.enums

import com.altkey.code.context.enums.CodeEnum

/**
 * 번호표 DB설정 Enum
 *
 * @author Kim Jung-tae(altkey)
 * @since 2025-07-05
 */
enum class OrderSetting(
    private val code: Long
) : CodeEnum {
    ESTIMATED_COOKING_TIME(0),
    MESSAGE(1)
    ;

    override fun getCode(): Long {
        return code
    }
}