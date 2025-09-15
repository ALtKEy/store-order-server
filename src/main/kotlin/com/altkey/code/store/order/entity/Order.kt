package com.altkey.code.store.order.entity

import com.altkey.code.context.store.order.enums.OrderStatus
import com.altkey.code.store.order.request.OrderRequest
import com.altkey.code.store.order.response.OrderResponse
import jakarta.persistence.*

/**
 * 주문
 *
 * @author Kim Jung-tae(altkey)
 * @since 2025-04-08
 */
@Entity
@Table(name = "orders", indexes = [
        Index(name = "idx_category_n_value", columnList = "category_id, value"),
        Index(name = "idx_update_dt_n_status", columnList = "update_date_time, status")
    ]
)
class Order (
    //
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    override val id: Long? = null,

    /**
     * 카테고리 (전화, 배달의민족, 네이버 등)
     */
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    var category: Category,

    /**
     * 데이터 (번호, 성함, 기타 문자들)
     */
    @Column(length = 100, nullable = false)
    var value: String,

    /**
     * 상태
     */
    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    var status: OrderStatus
) : AbstractEntity(id) {
    constructor(request: OrderRequest): this(
        category = Category(id = request.category.id),
        value = request.value,
        status = request.status
    )

    constructor(id: Long, request: OrderRequest): this(
        id = id,
        category = Category(id = request.category.id),
        value = request.value,
        status = request.status
    )

    fun toResponse(): OrderResponse {
        return OrderResponse(id=this.id, category = this.category, value = this.value, createdDateTime = this.createDateTime, updatedDateTime = this.updateDateTime, status = this.status)
    }
}