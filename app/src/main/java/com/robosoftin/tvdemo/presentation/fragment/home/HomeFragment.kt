package com.robosoftin.tvdemo.presentation.fragment.home

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.leanback.app.BackgroundManager
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.HeaderItem
import androidx.leanback.widget.ListRow
import androidx.leanback.widget.ListRowPresenter
import com.robosoftin.tvdemo.R
import com.robosoftin.tvdemo.data.products.ProductsResponseModel
import com.robosoftin.tvdemo.data.util.Resource
import com.robosoftin.tvdemo.databinding.FragmentHomeBinding
import com.robosoftin.tvdemo.presentation.activity.main.MainActivity
import com.robosoftin.tvdemo.presentation.viewmodel.home.ProductViewModel


class HomeFragment : BrowseSupportFragment() {

    private var TAG: String = HomeFragment::class.java.simpleName

    private var viewModel: ProductViewModel? = null
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding

    private var categoriesList: ArrayList<String> = arrayListOf()

    private val backgroundManager by lazy {
        BackgroundManager.getInstance(requireActivity()).apply {
            attach(requireActivity().window)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = getString(R.string.app_name)

        if (savedInstanceState == null) {
            prepareEntranceTransition()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).productViewModel
        Log.e(TAG, "onViewCreated: ")
        getCategoriesDetails()
    }

    private fun getProductDetails() {
        Log.e(TAG, "getProductDetails: ")
        viewModel?.getProduct()?.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Success -> {
                    try {
                        response.data?.let {
                            try {
                                Log.e(TAG, "displayData:")
                                displayData(it)
                                startEntranceTransition()
                            } catch (e: Exception) {
                                Log.e(TAG, "Exception: $e")
                            }
                        }
                    } catch (e: Exception) {
                        Log.e(TAG, "Exception: $e")
                    }
                }
                is Resource.Error -> {
                    Log.e(TAG, "Error: ")
                    response.message?.let {
                        Log.e(TAG, "submitLogin: $it")
                        Handler(Looper.getMainLooper()).post {
                            Toast.makeText(
                                activity,
                                "An error occurred : $it",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                }
                is Resource.Loading -> {
                    Log.e(TAG, "Loading: ")
                }
            }
        }

        viewModel?.getProductsList()
    }

    private fun getCategoriesDetails() {
        Log.e(TAG, "getCategoriesDetails: ")
        viewModel?.getCategories()?.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Success -> {
                    try {
                        response.data?.let {
                            try {
                                Log.e(TAG, "categoriesList:")
                                categoriesList.addAll(it)
                                getProductDetails()
                            } catch (e: Exception) {
                                Log.e(TAG, "Exception: $e")
                            }
                        }
                    } catch (e: Exception) {
                        Log.e(TAG, "Exception: $e")
                    }
                }
                is Resource.Error -> {
                    Log.e(TAG, "Error: ")
                    response.message?.let {
                        Log.e(TAG, "submitLogin: $it")
                        Handler(Looper.getMainLooper()).post {
                            Toast.makeText(
                                activity,
                                "An error occurred : $it",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                }
                is Resource.Loading -> {
                    Log.e(TAG, "Loading: ")
                }
            }
        }

        viewModel?.getCategoriesList()
    }

    private fun displayData(productsResponseModel: ProductsResponseModel) {
        val adapter = ArrayObjectAdapter(ListRowPresenter())
        for (i in 0 until categoriesList.size) {
            val headerItem = HeaderItem(i.toLong(), categoriesList.get(i))
            val rowAdapter = ArrayObjectAdapter(ProductPresenter())
            for(j in 0 until productsResponseModel.products.size){
                if(categoriesList.get(i).equals(productsResponseModel.products.get(j).category)) {
                    rowAdapter.add(productsResponseModel.products.get(j))
                }
            }
            adapter.add(ListRow(headerItem,rowAdapter))
        }
        this.adapter=adapter
    }
}

