package com.altkey.code.store.order.controller

import com.altkey.code.context.store.order.enums.OrderStatus
import com.altkey.code.store.order.entity.Order
import com.altkey.code.store.order.request.OrderRequest
import com.altkey.code.store.order.response.OrderResponse
import com.altkey.code.store.order.service.OrderService
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/order")
class OrderController(
    private val broadcaster: SimpMessagingTemplate,
    private val orderService: OrderService
) {
    private val logger = KotlinLogging.logger {}

    @PostMapping("/")
    fun newOrder(@RequestBody orderRequest: OrderRequest): OrderResponse {
        val order = Order(orderRequest)
        val savedOrder = orderService.new(order)
        val response = savedOrder.toResponse()
        broadcaster.convertAndSend("/topic/order", response)
        return response
    }

    @PutMapping("/{id}")
    fun updateOrder(@PathVariable id: Long, @RequestBody orderRequest: OrderRequest): OrderResponse {
        val existingOrder = Order(id, orderRequest)
        val updatedOrder = orderService.edit(existingOrder)
        val response = updatedOrder.toResponse()
        broadcaster.convertAndSend("/topic/order", response)
        return response
    }

    @GetMapping("/{id}")
    fun getOrder(@PathVariable id: Long): OrderResponse {
        val order: Order = orderService.get(id)
        return order.toResponse()
    }

    @GetMapping("/")
    fun getAllOrder(): List<OrderResponse> {
        val orders: List<Order> = orderService.getAll()
        return orders.map { it.toResponse() }
    }

    @GetMapping("/page/{number}")
    fun getOrderPage(@PathVariable number: Int): List<OrderResponse> {
        val orders: List<Order> = orderService.getList(number)
        return orders.map { it.toResponse() }
    }

    @GetMapping("/status/{status}/page/{limit}")
    fun getOrderPage(@PathVariable status: OrderStatus, @PathVariable limit : Int): List<OrderResponse> {
        val orders: List<Order> = orderService.getStatusAndLimit(status, limit)
        return orders.map { it.toResponse() }
    }
}
