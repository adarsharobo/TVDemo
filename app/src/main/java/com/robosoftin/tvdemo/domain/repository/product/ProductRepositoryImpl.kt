package com.robosoftin.tvdemo.domain.repository.product

import com.robosoftin.tvdemo.data.products.ProductsResponse
import com.robosoftin.tvdemo.data.repository.product.datasource.ProductRemoteDataSource
import com.robosoftin.tvdemo.data.util.Resource

import retrofit2.Response

class ProductRepositoryImpl (private val productRemoteDataSource: ProductRemoteDataSource) :
    ProductRepository {
    override suspend fun getProducts(): Resource<ProductsResponse> {
        return responseToResource(productRemoteDataSource.getProducts())
    }

    private fun responseToResource(response: Response<ProductsResponse>): Resource<ProductsResponse> {
        if (response.isSuccessful) {
            response.body()?.let { result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }
}
