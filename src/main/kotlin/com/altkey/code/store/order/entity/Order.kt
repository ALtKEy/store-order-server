package com.altkey.code.store.order.entity

import com.altkey.code.context.store.order.enums.OrderStatus
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

/**
 * 주문
 *
 * @author Kim Jung-tae(altkey)
 * @since 2025-04-08
 */
@Entity
@Table(name = "orders")
class Order (
    /**
     * 고유 ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long,

    /**
     * 카테고리 (전화, 배달의민족, 네이버 등)
     */
    @OneToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private val category: Category,

    /**
     * 데이터 (번호, 성함, 기타 문자들)
     */
    @Column(nullable = false)
    private val value: String,

    /**
     * 생성일
     */
    @CreationTimestamp
    private val createdDateTime: LocalDateTime,

    /**
     * 수정일
     */
    @UpdateTimestamp
    private val updatedDateTime: LocalDateTime,

    /**
     * 상태
     */
    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private val status: OrderStatus
) {
}