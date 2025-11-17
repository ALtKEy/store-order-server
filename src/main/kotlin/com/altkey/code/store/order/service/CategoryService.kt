package com.altkey.code.store.order.service

import com.altkey.code.store.order.entity.Category

interface CategoryService {

    fun getId(id: Long): Category

    fun getAll(): List<Category>

    fun new(category: Category): Category

    fun update(category: Category): Category
}