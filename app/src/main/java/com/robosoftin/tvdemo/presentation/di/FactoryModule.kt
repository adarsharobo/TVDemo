package com.robosoftin.tvdemo.presentation.di

import android.app.Application
import com.robosoftin.tvdemo.domain.usecase.categories.CategoriesUseCase
import com.robosoftin.tvdemo.domain.usecase.product.ProductUseCase
import com.robosoftin.tvdemo.presentation.viewmodel.home.ProductViewModelFactory
import com.robosoftin.tvdemo.presentation.viewmodel.splash.SplashViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
class FactoryModule {

    @ActivityRetainedScoped
    @Provides
    fun provideSplashViewModelFactory(
        application: Application
    ): SplashViewModelFactory {
        return SplashViewModelFactory(
            application
        )
    }

    @ActivityRetainedScoped
    @Provides
    fun provideProductViewModelFactory(
        application: Application,
        productUseCase: ProductUseCase,
        categoriesUseCase: CategoriesUseCase
    ): ProductViewModelFactory {
        return ProductViewModelFactory(
            application,
            productUseCase,
            categoriesUseCase
        )
    }
}








