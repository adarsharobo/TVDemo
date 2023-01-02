package com.robosoftin.tvdemo.presentation.viewmodel.home

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.robosoftin.tvdemo.domain.usecase.categories.CategoriesUseCase
import com.robosoftin.tvdemo.domain.usecase.product.ProductUseCase

class ProductViewModelFactory(
    private val app: Application,
    private val productUseCase: ProductUseCase,
    private val categoriesUseCase: CategoriesUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProductViewModel(
            app,
            productUseCase,
            categoriesUseCase
        ) as T
    }
}