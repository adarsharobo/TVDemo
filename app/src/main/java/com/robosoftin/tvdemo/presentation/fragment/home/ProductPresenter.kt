package com.robosoftin.tvdemo.presentation.fragment.home

import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.leanback.widget.Presenter
import com.robosoftin.tvdemo.R
import com.robosoftin.tvdemo.data.products.ProductDetails
import com.robosoftin.tvdemo.utils.StandardCardView

class ProductPresenter : Presenter() {
    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {

        val standardCardView = StandardCardView(parent.context)
        standardCardView.isFocusable = true
        standardCardView.isFocusableInTouchMode = true
        standardCardView.isClickable = true
        return ViewHolder(standardCardView)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, item: Any) {
        val product = item as ProductDetails
        (viewHolder.view as StandardCardView).apply {
            bindData(product)
        }

        setOnFocusChangeListener(viewHolder, item)
    }

    private fun setOnFocusChangeListener(viewHolder: ViewHolder, item: Any) {
        viewHolder.view.setOnFocusChangeListener { view, hasFocus ->
            when (view) {
                is StandardCardView -> {
                    view.apply {
                        findViewById<TextView>(R.id.tv_title).setTextColor(
                            ContextCompat.getColor(view.context, if (hasFocus) R.color._0074BC else R.color.white)
                        )

                        findViewById<TextView>(R.id.tv_description).setTextColor(
                            ContextCompat.getColor(view.context, if (hasFocus) R.color._0074BC else R.color.white)
                        )

                        findViewById<TextView>(R.id.tv_price).setTextColor(
                            ContextCompat.getColor(view.context, if (hasFocus) R.color._0074BC else R.color.white)
                        )
                    }
                }
            }
        }
    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder) {
        with(viewHolder.view as StandardCardView) {

        }
    }
}