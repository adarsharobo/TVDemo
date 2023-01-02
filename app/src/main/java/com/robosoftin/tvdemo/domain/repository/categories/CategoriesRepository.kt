package com.robosoftin.tvdemo.domain.repository.categories

import com.robosoftin.tvdemo.data.util.Resource

interface CategoriesRepository {
    suspend fun getCategories(): Resource<List<String>>
}