package com.altkey.code.store.order.service

import com.altkey.code.context.collection.PaginationList
import com.altkey.code.context.store.order.enums.OrderStatus
import com.altkey.code.store.order.entity.Order

/**
 *
 * @author Kim Jung-tae(altkey)
 * @since 2025-09-09
 */
interface OrderService {
    //
    fun new(order: Order): Order

    fun edit(order: Order): Order

    fun editStatus(id: Long, status: OrderStatus): Order

    fun get(id: Long): Order

    fun getList(pageNo: Int): PaginationList<Order>

    fun getAll(): List<Order>

    fun getStatusAndLimit(status: OrderStatus, limit: Int): List<Order>
}