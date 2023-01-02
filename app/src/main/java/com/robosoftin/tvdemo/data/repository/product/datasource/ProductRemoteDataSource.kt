package com.robosoftin.tvdemo.data.repository.product.datasource

import com.robosoftin.tvdemo.data.products.ProductsResponseModel
import retrofit2.Response

interface ProductRemoteDataSource {
    suspend fun getProducts(
    ): Response<ProductsResponseModel>
}