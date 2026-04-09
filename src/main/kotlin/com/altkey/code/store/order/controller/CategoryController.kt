package com.altkey.code.store.order.controller

import com.altkey.code.store.order.entity.Category
import com.altkey.code.store.order.response.CategoryResponse
import com.altkey.code.store.order.service.CategoryService
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class CategoryController (private val service: CategoryService) {

    @QueryMapping
    fun category(@Argument id: Long): CategoryResponse {
        return service.getId(id).toResponse()
    }
    @QueryMapping
    fun categories(): List<CategoryResponse> {
        return service.getAll().map { it.toResponse() }
    }
    @MutationMapping
    fun newCategory(@Argument value: String): CategoryResponse {
        return service.new(Category(value = value)).toResponse()
    }
    @MutationMapping
    fun updateCategory(@Argument id: Long, @Argument value: String): CategoryResponse {
        return service.update(Category(id = id, value = value)).toResponse()
    }
}
