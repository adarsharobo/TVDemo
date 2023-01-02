package com.robosoftin.tvdemo.utils

import android.content.Context
import android.graphics.Rect
import android.os.Build
import android.view.LayoutInflater
import androidx.annotation.RequiresApi
import androidx.leanback.widget.BaseCardView
import com.bumptech.glide.Glide
import com.robosoftin.tvdemo.R
import com.robosoftin.tvdemo.data.products.ProductDetails
import com.robosoftin.tvdemo.databinding.LayoutStandardcardviewBinding

class StandardCardView(context: Context) : BaseCardView(context) {
    private var TAG: String = StandardCardView::class.java.simpleName
    private var binding: LayoutStandardcardviewBinding

    init {
        binding = LayoutStandardcardviewBinding.inflate(LayoutInflater.from(context), this, false)
        addView(binding.root)
    }

    fun bindData(model: ProductDetails) {
        Glide.with(context)
            .load(model.thumbnail)
            .placeholder(R.drawable.movie)
            .centerCrop()
            .into(binding.imgProduct)

        binding.tvTitle.text = model.title
        binding.tvDescription.text = model.description
        binding.tvPrice.text = model.price.toString()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onFocusChanged(gainFocus: Boolean, direction: Int, previouslyFocusedRect: Rect?) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect)
        binding.layCardview.foreground =
            context.getDrawable((if (gainFocus) R.drawable.layout_border_white else R.drawable.layout_border_transparent))
    }
}