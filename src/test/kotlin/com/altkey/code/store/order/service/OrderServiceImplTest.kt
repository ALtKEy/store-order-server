package com.altkey.code.store.order.service

import com.altkey.code.context.store.order.enums.OrderStatus
import com.altkey.code.store.order.boot.StoreOrderApplication
import com.altkey.code.store.order.entity.Category
import com.altkey.code.store.order.entity.Order
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

/**
 *
 * @author Kim Jung-tae(altkey)
 * @since 2025-09-09
 */
@SpringBootTest(classes = [StoreOrderApplication::class], properties = [
    "module.name=store-order",
    "module.home=.",
    "config.home=./config/"
])
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class OrderServiceImplTest {
    //
    @Autowired
    private lateinit var orderService: OrderService

    @Test
    @org.junit.jupiter.api.Order(1)
    fun new() {
        val order: Order = Order(
            category = Category(id = 0L, value = "abc"),
            value = "#1234",
            status = OrderStatus.PENDING
        )
        orderService.new(order)
    }

    @Test
    fun edit() {
    }

    @Test
    @org.junit.jupiter.api.Order(2)
    fun editStatus() {
        orderService.editStatus(1L, OrderStatus.SERVED)
    }

    @Test
    fun get() {
    }

    @Test
    fun getList() {
    }

    @Test
    fun getAll() {
    }

}