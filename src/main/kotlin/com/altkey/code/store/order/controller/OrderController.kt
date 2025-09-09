package com.altkey.code.store.order.controller

import com.altkey.code.context.response.CategoryResponse
import com.altkey.code.context.response.OrderResponse
import com.altkey.code.context.store.order.enums.OrderStatus
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
@RequestMapping("/order")
class OrderController(private val messagingTemplate: SimpMessagingTemplate){

    private val logger = KotlinLogging.logger {}

    @PostMapping("/")
    fun createOrder(@RequestBody newOrder: OrderResponse) : OrderResponse {
        val category = CategoryResponse(
            id = 1L,
            value = "전화",
            createDateTime = LocalDateTime.now().minusDays(1),
            updateDateTime = LocalDateTime.now(),
            deleted = false
        )

        val orderResponse = OrderResponse(
            id = 1L,
            category = category,
            value = "010-1234-4578 김철수",
            createdDateTime = LocalDateTime.now().minusDays(1),
            updatedDateTime = LocalDateTime.now(),
            status = OrderStatus.SERVED
        )
        messagingTemplate.convertAndSend("/refresh/order", orderResponse)

        return newOrder
    }
}