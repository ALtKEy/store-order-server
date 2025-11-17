package com.altkey.code.store.order.service

import com.altkey.code.store.order.entity.Category
import com.altkey.code.store.order.repository.CategoryRepository
import org.springframework.stereotype.Service

@Service
class CategroyServiceImpl(
    private val repository : CategoryRepository
): CategoryService{
    override fun getId(id: Long): Category{
        return repository.getReferenceById(id)
    }

    override fun getAll(): List<Category>{
        return repository.findAll()
    }

    override fun new(category: Category): Category{
        return repository.saveAndFlush<Category>(category)
    }

    override fun update(category: Category): Category{
        return repository.saveAndFlush<Category>(category)
    }
}