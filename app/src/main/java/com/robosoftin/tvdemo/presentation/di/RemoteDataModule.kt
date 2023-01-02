package com.robosoftin.tvdemo.presentation.di

import com.robosoftin.tvdemo.data.api.APIServices
import com.robosoftin.tvdemo.data.repository.categories.datasource.CategoriesRemoteDataSource
import com.robosoftin.tvdemo.data.repository.categories.datasourceImpl.CategoriesRemoteDataSourceImpl
import com.robosoftin.tvdemo.data.repository.product.datasource.ProductRemoteDataSource
import com.robosoftin.tvdemo.data.repository.product.datasourceImpl.ProductRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RemoteDataModule {

    @Singleton
    @Provides
    fun provideProductRemoteDataSource(
        APIServices: APIServices
    ): ProductRemoteDataSource {
        return ProductRemoteDataSourceImpl(APIServices)
    }

    @Singleton
    @Provides
    fun provideCategoriesRemoteDataSource(
        APIServices: APIServices
    ): CategoriesRemoteDataSource {
        return CategoriesRemoteDataSourceImpl(APIServices)
    }
}












