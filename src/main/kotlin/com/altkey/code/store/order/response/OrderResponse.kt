package com.altkey.code.store.order.response

import com.altkey.code.context.store.order.enums.OrderStatus
import com.altkey.code.store.order.entity.Category
import com.altkey.code.store.order.entity.Order
import com.altkey.code.store.order.request.CommonIdRequest
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import java.time.LocalDateTime

class OrderResponse (
    /**
     * 고유 ID
     */
    var id: Long?,

    /**
     * 카테고리 (전화, 배달의민족, 네이버 등)
     */
    var category: Category,

    /**
     * 데이터 (번호, 성함, 기타 문자들)
     */
    var value: String,

    /**
     * 생성일
     */
    var createdDateTime: LocalDateTime,

    /**
     * 수정일
     */
    var updatedDateTime: LocalDateTime?,

    /**
     * 상태
     */
    @Enumerated(EnumType.ORDINAL)
    var status: OrderStatus
)
{

}