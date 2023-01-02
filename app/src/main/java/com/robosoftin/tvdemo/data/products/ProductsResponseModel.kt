package com.robosoftin.tvdemo.data.products

import com.google.gson.annotations.SerializedName

data class ProductsResponseModel(
    @SerializedName("products") var products: MutableList<ProductDetails> = mutableListOf(),
    @SerializedName("total") var total: Int? = null,
    @SerializedName("skip") var skip: Int? = null,
    @SerializedName("limit") var limit: Int? = null
)
