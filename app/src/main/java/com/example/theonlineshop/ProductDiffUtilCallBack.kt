package com.example.theonlineshop

import androidx.recyclerview.widget.DiffUtil
import kotlin.math.sign

class ProductDiffUtilCallBack(
    private val oldList: List<Product>, private val newList: List<Product>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        newList[newItemPosition].id == oldList[oldItemPosition].id


    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        newList[newItemPosition] == oldList[oldItemPosition]

}
