package com.robosoftin.tvdemo.data.repository.categories.datasource

import retrofit2.Response

interface CategoriesRemoteDataSource {
    suspend fun getCategories(
    ): Response<List<String>>
}