package com.robosoftin.tvdemo.presentation.fragment.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.asLiveData
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.robosoftin.tvdemo.R
import com.robosoftin.tvdemo.databinding.FragmentSplashBinding
import com.robosoftin.tvdemo.presentation.activity.main.MainActivity
import com.robosoftin.tvdemo.presentation.viewmodel.splash.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment :Fragment(){

    private var viewModel: SplashViewModel? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentSplashBinding.inflate(inflater, container, false)
        viewModel = (activity as MainActivity).splashViewModel
        viewModel?.shouldGoToHome?.asLiveData()?.observe(viewLifecycleOwner) { shouldGoToHome ->
            if (shouldGoToHome) {
                goToHome()
            }
        }

        return binding.root
    }

    private fun goToHome() {
        findNavController().navigate(
            SplashFragmentDirections.actionSplashFragmentToHomeFragment(),
            NavOptions.Builder()
                .setPopUpTo(R.id.splash_fragment, true)
                .build()
        )
    }
}