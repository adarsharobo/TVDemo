package com.robosoftin.tvdemo.data.products

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("id") var id: Int? = 0,
    @SerializedName("title") var title: String? = "",
    @SerializedName("description") var description: String? = "",
    @SerializedName("price") var price: Int? = 0,
    @SerializedName("discountPercentage") var discountPercentage: Double? = 0.0,
    @SerializedName("rating") var rating: Double? = 0.0,
    @SerializedName("stock") var stock: Int? = 0,
    @SerializedName("brand") var brand: String? = "",
    @SerializedName("category") var category: String? = "",
    @SerializedName("thumbnail") var thumbnail: String? = "",
    @SerializedName("images") var images: ArrayList<String> = arrayListOf()

)