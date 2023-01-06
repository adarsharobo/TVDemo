package com.robosoftin.tvdemo.data.products

import com.google.gson.annotations.SerializedName

data class ProductsResponse(
    @SerializedName("products") var products: MutableList<Product> = mutableListOf(),
    @SerializedName("total") var total: Int? = null,
    @SerializedName("skip") var skip: Int? = null,
    @SerializedName("limit") var limit: Int? = null
)
