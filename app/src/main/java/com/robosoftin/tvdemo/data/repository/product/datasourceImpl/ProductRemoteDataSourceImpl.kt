package com.robosoftin.tvdemo.data.repository.product.datasourceImpl

import com.robosoftin.tvdemo.data.api.APIServices
import com.robosoftin.tvdemo.data.products.ProductsResponse
import com.robosoftin.tvdemo.data.repository.product.datasource.ProductRemoteDataSource
import retrofit2.Response

class ProductRemoteDataSourceImpl (private val APIServices: APIServices) :
    ProductRemoteDataSource {

    override suspend fun getProducts(): Response<ProductsResponse> {
        return APIServices.getProducts()
    }
}