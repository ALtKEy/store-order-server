package com.altkey.code.store.order.controller

import com.altkey.code.context.store.order.enums.OrderStatus
import com.altkey.code.store.order.entity.Category
import com.altkey.code.store.order.entity.Order
import com.altkey.code.store.order.request.OrderRequest
import com.altkey.code.store.order.response.OrderResponse
import com.altkey.code.store.order.service.OrderService
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Controller

@Controller
class OrderController(
    private val broadcaster: SimpMessagingTemplate,
    private val orderService: OrderService
) {
    private val logger = KotlinLogging.logger {}

    @MutationMapping
    fun newOrder(@Argument order: OrderRequest): OrderResponse {
        val newOrder = Order(
            category = Category(id = order.category.id),
            value = order.value,
            status = order.status
        )
        val savedOrder = orderService.new(newOrder)
        val response = savedOrder.toResponse()
        broadcaster.convertAndSend("/topic/order", response)
        return response
    }

    @MutationMapping
    fun updateOrder(@Argument order: OrderRequest): OrderResponse {
        val existingOrder = Order(
            id = order.id,
            category = Category(id = order.category.id),
            value = order.value,
            status = order.status
        )
        val updatedOrder = orderService.edit(existingOrder)
        val response = updatedOrder.toResponse()
        broadcaster.convertAndSend("/topic/order", response)
        return response
    }

    @MutationMapping
    fun updateOrderStatus(@Argument id: Long, @Argument status: OrderStatus): OrderResponse {
        val order = orderService.get(id)
        order.status = status
        val updatedOrder = orderService.edit(order)
        val response = updatedOrder.toResponse()
        broadcaster.convertAndSend("/topic/order", response)
        return response
    }

    @QueryMapping
    fun getOrder(@Argument id: Long): OrderResponse {
        val order: Order = orderService.get(id)
        return order.toResponse()
    }

    @QueryMapping
    fun orders(): List<OrderResponse> {
        val orders: List<Order> = orderService.getAll()
        return orders.map { it.toResponse() }
    }

    @QueryMapping
    fun orderPage(@Argument number: Int): List<OrderResponse> {
        val orders: List<Order> = orderService.getList(number)
        return orders.map { it.toResponse() }
    }

    @QueryMapping
    fun ordersByStatusAndLimit(@Argument status: OrderStatus, @Argument limit: Int): List<OrderResponse> {
        val orders: List<Order> = orderService.getStatusAndLimit(status, limit)
        return orders.map { it.toResponse() }
    }
}