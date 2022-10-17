package com.example.theonlineshop

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class ProductRecyclerAdapter : RecyclerView.Adapter<ProductRecyclerAdapter.ViewHolder>() {

    private var dataSet = ArrayList<Product>()

    fun setData(productArrayList: List<Product>) {
        val productDiffUtilCallback = ProductDiffUtilCallBack(dataSet, productArrayList)
        val diffResult = DiffUtil.calculateDiff(productDiffUtilCallback)
        dataSet.clear()
        dataSet.addAll(productArrayList)
        diffResult.dispatchUpdatesTo(this)

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bigText: TextView = itemView.findViewById(R.id.biggerText)
        val smallText: TextView = itemView.findViewById(R.id.smallerText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.items_of_recyclerview, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = dataSet[position]
        holder.bigText.text = product.name
        holder.smallText.text =
            "${product.type}, price:${product.price}€, amount left:${product.quantity}"
    }

}