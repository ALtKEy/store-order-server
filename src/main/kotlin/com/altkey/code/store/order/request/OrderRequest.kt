package com.altkey.code.store.order.request

import com.altkey.code.context.store.order.enums.OrderStatus
import com.altkey.code.store.order.entity.Category
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated

data class OrderRequest (
    /**
     * 카테고리 (전화, 배달의민족, 네이버 등)
     */
    var category: CommonIdRequest,

    /**
     * 데이터 (번호, 성함, 기타 문자들)
     */
    var value: String,

    /**
     * 상태
     */
    @Enumerated(EnumType.ORDINAL)
    var status: OrderStatus
)