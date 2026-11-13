package com.example.lita_3tif.Home.Pertemuan_11

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lita_3tif.R
import com.example.lita_3tif.databinding.ItemProductBinding

class ProductAdapter(
    private val productList: List<ProductModel>,
    private val onItemClick: (ProductModel) -> Unit
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(val binding: ItemProductBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ItemProductBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val item = productList[position]
        with(holder.binding) {
            tvProductName.text = item.name
            tvProductPrice.text = item.price

            Glide.with(holder.itemView.context)
                .load(item.imageUrl)
                .into(imgProduct)

            root.setOnClickListener {
                onItemClick(item)
            }
        }
        Log.e("TEST RV", item.name)
    }

    override fun getItemCount(): Int = productList.size
}