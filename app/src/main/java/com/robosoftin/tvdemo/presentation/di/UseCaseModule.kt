package com.robosoftin.tvdemo.presentation.di

import com.robosoftin.tvdemo.domain.repository.categories.CategoriesRepository
import com.robosoftin.tvdemo.domain.repository.product.ProductRepository
import com.robosoftin.tvdemo.domain.usecase.categories.CategoriesUseCase
import com.robosoftin.tvdemo.domain.usecase.product.ProductUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun provideProductUseCase(
        productRepository: ProductRepository
    ): ProductUseCase {
        return ProductUseCase(productRepository)
    }

    @Singleton
    @Provides
    fun provideCategoriesUseCase(
        categoriesRepository: CategoriesRepository
    ): CategoriesUseCase {
        return CategoriesUseCase(categoriesRepository)
    }
}