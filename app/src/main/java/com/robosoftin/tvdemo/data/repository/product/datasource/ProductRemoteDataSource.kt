package com.robosoftin.tvdemo.data.repository.product.datasource

import com.robosoftin.tvdemo.data.products.ProductsResponse
import retrofit2.Response

interface ProductRemoteDataSource {
    suspend fun getProducts(
    ): Response<ProductsResponse>
}