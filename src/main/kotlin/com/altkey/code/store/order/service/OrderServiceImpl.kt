package com.altkey.code.store.order.service

import com.altkey.code.context.collection.PaginationList
import com.altkey.code.context.entity.Pagination
import com.altkey.code.context.store.order.enums.OrderStatus
import com.altkey.code.store.order.entity.Order
import com.altkey.code.store.order.repository.OrderRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 *
 * @author Kim Jung-tae(altkey)
 * @since 2025-09-09
 */
@Service
class OrderServiceImpl(
    private val repository: OrderRepository
) : OrderService {
    //
    @Transactional
    override fun new(order: Order): Order {
        return repository.save<Order>(order)
    }

    @Transactional
    override fun edit(order: Order): Order {
        return repository.saveAndFlush(order)
    }

    @Transactional
    override fun editStatus(
        id: Long,
        status: OrderStatus
    ): Order {
        repository.updateStatusById(id, status)
        return repository.getReferenceById(id);
    }

    override fun get(id: Long): Order {
        return repository.getReferenceById(id);
    }

    override fun getList(pageNo: Int): PaginationList<Order> {
        val pagination = Pagination(currentPage = pageNo, pageItemSize = 10);
        pagination.initalize(repository.count())
        val orders: Page<Order> = repository.findAll(PageRequest.of(pagination.getOffset(), pagination.pageItemSize))
        return pagination.of(orders)
    }

    override fun getAll(): List<Order> {
        return repository.findAll();
    }
}