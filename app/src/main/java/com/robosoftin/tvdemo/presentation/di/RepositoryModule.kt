package com.robosoftin.tvdemo.presentation.di


import com.robosoftin.tvdemo.data.repository.categories.datasource.CategoriesRemoteDataSource
import com.robosoftin.tvdemo.data.repository.product.datasource.ProductRemoteDataSource
import com.robosoftin.tvdemo.domain.repository.categories.CategoriesRepository
import com.robosoftin.tvdemo.domain.repository.categories.CategoriesRepositoryImpl
import com.robosoftin.tvdemo.domain.repository.product.ProductRepository
import com.robosoftin.tvdemo.domain.repository.product.ProductRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideProductRepository(
        productRemoteDataSource: ProductRemoteDataSource,
    ): ProductRepository {
        return ProductRepositoryImpl(
            productRemoteDataSource
        )
    }

    @Singleton
    @Provides
    fun provideCategoriesRepository(
        categoriesRemoteDataSource: CategoriesRemoteDataSource,
    ): CategoriesRepository {
        return CategoriesRepositoryImpl(
            categoriesRemoteDataSource
        )
    }
}














