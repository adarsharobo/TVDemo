package com.robosoftin.tvdemo.domain.repository.product

import com.robosoftin.tvdemo.data.products.ProductsResponse
import com.robosoftin.tvdemo.data.util.Resource

interface ProductRepository {
    suspend fun getProducts(): Resource<ProductsResponse>
}