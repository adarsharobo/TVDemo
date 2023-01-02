package com.robosoftin.tvdemo.domain.usecase.categories

import com.robosoftin.tvdemo.data.util.Resource
import com.robosoftin.tvdemo.domain.repository.categories.CategoriesRepository

class CategoriesUseCase (private val categoriesRepository: CategoriesRepository) {
    suspend fun execute(): Resource<List<String>> {
        return categoriesRepository.getCategories()
    }
}