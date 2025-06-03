package com.altkey.code.context.store.order.entity

import com.altkey.code.context.store.order.enums.OrderStatus
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

/**
 * 주문
 *
 * @author Kim Jung-tae(altkey)
 * @since 2025-04-08
 */
@Entity
@Table(name = "orders")
class Order(
    /**
     * 고유 ID
     */
    @Id
    private val id: Long,

    /**
     * 데이터 (번호, 성함, 기타 문자들)
     */
    @Column(columnDefinition = "VARCHAR(16)")
    private val value: String,

    /**
     * 생성일
     */
    @Column(columnDefinition = "DATETIME")
    private val createdDateTime: LocalDateTime,

    /**
     * 수정일
     */
    @Column(columnDefinition = "DATETIME")
    private val updatedDateTime: LocalDateTime,

    /**
     * 상태
     */
    @Column(columnDefinition = "CHAR(1)")
    private val status: OrderStatus
) {
}