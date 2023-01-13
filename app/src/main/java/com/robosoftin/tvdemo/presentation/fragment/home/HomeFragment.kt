package com.robosoftin.tvdemo.presentation.fragment.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.leanback.app.BrowseSupportFragment.HEADERS_DISABLED
import androidx.leanback.app.RowsSupportFragment
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.HeaderItem
import androidx.leanback.widget.ListRow
import androidx.leanback.widget.ListRowPresenter
import com.robosoftin.tvdemo.data.products.ProductsResponse
import com.robosoftin.tvdemo.data.util.Resource
import com.robosoftin.tvdemo.presentation.activity.main.MainActivity
import com.robosoftin.tvdemo.presentation.viewmodel.home.ProductViewModel


class HomeFragment : RowsSupportFragment() {

    private var TAG: String = HomeFragment::class.java.simpleName

    private var viewModel: ProductViewModel? = null

    private var categoriesList: ArrayList<String> = arrayListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*BackgroundManager.getInstance(requireActivity()).apply {
            attach(requireActivity().window)
        }*/
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).productViewModel
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
                    }
                }
                is Resource.Loading -> {
                    Log.e(TAG, "Loading: ")
                }
            }
        }

        viewModel?.getCategoriesList()
    }

    private fun displayData(productsResponseModel: ProductsResponse) {
        val adapter = ArrayObjectAdapter(ListRowPresenter())
        for (i in 0 until categoriesList.size) {
            val headerItem = HeaderItem(i.toLong(), categoriesList[i])
            val rowAdapter = ArrayObjectAdapter(ProductPresenter())
            for(j in 0 until productsResponseModel.products.size){
                if(categoriesList[i] == productsResponseModel.products[j].category) {
                    rowAdapter.add(productsResponseModel.products[j])
                }
            }
            adapter.add(ListRow(headerItem,rowAdapter))
        }
        this.adapter=adapter
    }
}

