package com.altkey.code.store.order.repository

import com.altkey.code.context.store.order.entity.Order
import com.linecorp.kotlinjdsl.support.spring.data.jpa.repository.KotlinJdslJpqlExecutor
import org.springframework.data.jpa.repository.JpaRepository

/**
 *
 * @author Kim Jung-tae(altkey)
 * @since 2025-07-01
 */
interface OrderRepository : JpaRepository<Order, Long>, KotlinJdslJpqlExecutor {
}