package com.robosoftin.tvdemo.presentation.activity.main

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import com.robosoftin.tvdemo.R
import com.robosoftin.tvdemo.data.api.APIServices
import com.robosoftin.tvdemo.presentation.viewmodel.home.ProductViewModel
import com.robosoftin.tvdemo.presentation.viewmodel.home.ProductViewModelFactory
import com.robosoftin.tvdemo.presentation.viewmodel.splash.SplashViewModel
import com.robosoftin.tvdemo.presentation.viewmodel.splash.SplashViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : FragmentActivity() {

    @Inject
    lateinit var apiServices: APIServices

    @Inject
    lateinit var splashViewModelFactory: SplashViewModelFactory
    lateinit var splashViewModel: SplashViewModel

    @Inject
    lateinit var productViewModelFactory: ProductViewModelFactory
    lateinit var productViewModel: ProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashViewModel = ViewModelProvider(this, splashViewModelFactory)
            .get(SplashViewModel::class.java)
        productViewModel = ViewModelProvider(this, productViewModelFactory)
            .get(ProductViewModel::class.java)
        setContentView(R.layout.activity_main)
    }
}
