package com.altkey.code.store.order.repository

import com.linecorp.kotlinjdsl.support.spring.data.jpa.repository.KotlinJdslJpqlExecutor
import com.altkey.code.context.store.order.entity.Category
import org.springframework.data.jpa.repository.JpaRepository

/**
 *
 * @author Kim Jung-tae(altkey)
 * @since 2025-07-01
 */
interface CategoryRepository : JpaRepository<Category, Long>, KotlinJdslJpqlExecutor {
}