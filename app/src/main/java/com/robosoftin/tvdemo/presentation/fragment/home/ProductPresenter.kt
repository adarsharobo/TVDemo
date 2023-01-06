package com.robosoftin.tvdemo.presentation.fragment.home

import android.view.ViewGroup
import androidx.leanback.widget.ImageCardView
import androidx.leanback.widget.Presenter
import com.bumptech.glide.Glide
import com.robosoftin.tvdemo.R
import com.robosoftin.tvdemo.data.products.Product

class ProductPresenter : Presenter() {

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {

        val imageCardView = ImageCardView(parent.context)
        imageCardView.isFocusable = true
        imageCardView.isFocusableInTouchMode = true
        imageCardView.isClickable = true

        return ViewHolder(imageCardView)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, item: Any) {
        val product = item as Product
        val cardView = viewHolder.view as ImageCardView

        (cardView).apply {
            Glide.with(context)
                .load(product.thumbnail)
                .placeholder(R.drawable.movie)
                .centerCrop()
                .into(cardView.mainImageView)
        }
        cardView.titleText = product.title
        cardView.setMainImageDimensions(313,
           176
        )
    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder) {
        /* with(viewHolder.view as StandardCardView) {

         }*/
    }
}