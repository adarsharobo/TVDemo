package com.robosoftin.tvdemo.data.repository.categories.datasourceImpl

import com.robosoftin.tvdemo.data.api.APIServices
import com.robosoftin.tvdemo.data.repository.categories.datasource.CategoriesRemoteDataSource
import retrofit2.Response

class CategoriesRemoteDataSourceImpl (private val APIServices: APIServices) :
    CategoriesRemoteDataSource {

    override suspend fun getCategories(): Response<List<String>> {
        return APIServices.getCategories()
    }
}