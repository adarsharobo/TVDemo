package com.robosoftin.tvdemo.presentation.viewmodel.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.robosoftin.tvdemo.data.products.ProductsResponse
import com.robosoftin.tvdemo.data.util.Resource
import com.robosoftin.tvdemo.domain.usecase.categories.CategoriesUseCase
import com.robosoftin.tvdemo.domain.usecase.product.ProductUseCase
import com.robosoftin.tvdemo.utils.Network
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductViewModel(private val app: Application,
                       private val productUseCase: ProductUseCase,
                       private val categoriesUseCase: CategoriesUseCase
) : AndroidViewModel(app) {

    var TAG: String = ProductViewModel::class.java.simpleName
    lateinit var productsResponse: MutableLiveData<Resource<ProductsResponse>>

    var scrollPos: Pair<Int, Int>? = null

    fun resetScrollPos() {
        scrollPos = null
    }

    fun getProduct(): MutableLiveData<Resource<ProductsResponse>> {
        productsResponse = MutableLiveData()
        return productsResponse
    }

    fun getProductsList() = viewModelScope.launch(Dispatchers.IO) {
        productsResponse.postValue(Resource.Loading())
        try {
            if (Network.isNetworkAvailable(app)) {
                val apiResult = productUseCase.execute()
//                Log.e(TAG, "getProducts: ${apiResult.data}", )
                productsResponse.postValue(apiResult)
            } else {
                productsResponse.postValue(Resource.Error("Internet is not available"))
            }
        } catch (e: Exception) {
            productsResponse.postValue(Resource.Error(e.message.toString()))
        }
    }

    lateinit var categoriesResponse: MutableLiveData<Resource<List<String>>>

    fun getCategories(): MutableLiveData<Resource<List<String>>> {
        categoriesResponse = MutableLiveData()
        return categoriesResponse
    }

    fun getCategoriesList() = viewModelScope.launch(Dispatchers.IO) {
        categoriesResponse.postValue(Resource.Loading())
        try {
            if (Network.isNetworkAvailable(app)) {
                val apiResult = categoriesUseCase.execute()
//                Log.e(TAG, "getProducts: ${apiResult.data}", )
                categoriesResponse.postValue(apiResult)
            } else {
                categoriesResponse.postValue(Resource.Error("Internet is not available"))
            }
        } catch (e: Exception) {
            categoriesResponse.postValue(Resource.Error(e.message.toString()))
        }
    }
}
