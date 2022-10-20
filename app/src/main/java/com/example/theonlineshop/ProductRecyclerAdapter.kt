package com.example.theonlineshop

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class ProductRecyclerAdapter : RecyclerView.Adapter<ProductRecyclerAdapter.ViewHolder>() {

    var dataSet = emptyList<Product>()
        set(value) {
            val productDiffUtilCallback = ProductDiffUtilCallBack(dataSet, field)
            val diffResult = DiffUtil.calculateDiff(productDiffUtilCallback)
            diffResult.dispatchUpdatesTo(this)
            field = value
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.items_of_recyclerview, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(dataSet[position])

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title: TextView = itemView.findViewById(R.id.title)
        private val subtitle: TextView = itemView.findViewById(R.id.subtitle)

        fun bind(product: Product) {
            title.text = product.name
            subtitle.text =
                "${product.type}, @+id/price:${product.price}€, amount left:${product.quantity}"
        }
    }
}