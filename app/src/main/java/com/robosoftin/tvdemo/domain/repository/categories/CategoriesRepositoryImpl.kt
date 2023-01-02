package com.robosoftin.tvdemo.domain.repository.categories

import com.robosoftin.tvdemo.data.repository.categories.datasource.CategoriesRemoteDataSource
import com.robosoftin.tvdemo.data.util.Resource
import retrofit2.Response

class CategoriesRepositoryImpl(private val categoriesRemoteDataSource: CategoriesRemoteDataSource) :
    CategoriesRepository {

    override suspend fun getCategories(): Resource<List<String>> {
        return responseToResource(categoriesRemoteDataSource.getCategories())
    }

    private fun responseToResource(response: Response<List<String>>): Resource<List<String>> {
        if (response.isSuccessful) {
            response.body()?.let { result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }
}