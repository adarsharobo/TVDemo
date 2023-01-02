package com.robosoftin.tvdemo.domain.usecase.product

import com.robosoftin.tvdemo.data.products.ProductsResponseModel
import com.robosoftin.tvdemo.data.util.Resource
import com.robosoftin.tvdemo.domain.repository.product.ProductRepository

class ProductUseCase (private val productRepository: ProductRepository) {
    suspend fun execute(): Resource<ProductsResponseModel> {
        return productRepository.getProducts()
    }
}