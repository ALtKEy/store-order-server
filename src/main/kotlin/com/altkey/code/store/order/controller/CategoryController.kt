package com.altkey.code.store.order.controller

import com.altkey.code.store.order.entity.Category
import com.altkey.code.store.order.entity.Order
import com.altkey.code.store.order.response.CategoryResponse
import com.altkey.code.store.order.service.CategoryService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/category")
class CategoryController (private val service: CategoryService) {

    @GetMapping("/{id}")
    fun getId(@PathVariable("id") id: Long): CategoryResponse {
        return service.getId(id).toResponse()
    }
    @GetMapping("/")
    fun getAll(): List<CategoryResponse> {
        return service.getAll().map { it.toResponse() }
    }
    @PostMapping("/")
    fun new(@RequestBody category: Category): CategoryResponse {
        return service.new(category).toResponse()
    }
    @PutMapping("/{id}")
    fun edit(@RequestBody category: Category): CategoryResponse {
        return service.update(category).toResponse()
    }
}