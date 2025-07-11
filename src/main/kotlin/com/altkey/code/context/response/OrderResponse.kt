package com.altkey.code.context.response

import com.altkey.code.context.store.order.enums.OrderStatus
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import java.time.LocalDateTime

class OrderResponse (
    /**
     * 고유 ID
     */
    @JsonIgnore
    var id: Long,

    /**
     * 카테고리 (전화, 배달의민족, 네이버 등)
     */
    var category: CategoryResponse,

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
    var updatedDateTime: LocalDateTime,

    /**
     * 상태
     */
    @Enumerated(EnumType.ORDINAL)
    var status: OrderStatus
)
{}