package com.robosoftin.tvdemo.presentation.viewmodel.splash

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.robosoftin.tvdemo.utils.mutableEventFlow
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class SplashViewModel (private val app: Application) : AndroidViewModel(app) {

    private val _shouldGoToHome = mutableEventFlow<Boolean>()
    val shouldGoToHome = _shouldGoToHome.asSharedFlow()

    init {
        viewModelScope.launch {
            delay(1500L)
            _shouldGoToHome.tryEmit(true)
        }
    }
}
