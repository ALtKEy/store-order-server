package com.altkey.code.context.store.order.enums

import com.altkey.code.context.enums.KeyEnum

/**
 *
 * @author Kim Jung-tae(altkey)
 * @since 2025-04-08
 */
enum class OrderStatus(
    private var key: Int
) : KeyEnum<Int> {
    /**
     * 대기
     */
    PENDING(0),

    /**
     * 완료(제공)
     */
    SERVED(1),

    /**
     * 주문 취소
     */
    DELETED(2),
    ;

    override fun getKey(): Int {
        return key
    }
}