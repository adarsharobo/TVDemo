package com.robosoftin.tvdemo.data.api

import com.robosoftin.tvdemo.data.products.ProductsResponse
import retrofit2.Response
import retrofit2.http.GET

interface APIServices {
    @GET("products")
    suspend fun getProducts(): Response<ProductsResponse>

    @GET("products/categories")
    suspend fun getCategories(): Response<List<String>>
}