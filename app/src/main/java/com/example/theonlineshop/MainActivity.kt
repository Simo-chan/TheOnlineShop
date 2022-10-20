package com.example.theonlineshop

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val productList = mutableListOf<Product>().apply {
            add(Product(1, "Tobias", "Chair", 89.90, 153))
            add(Product(2, "Adde", "Chair", 15.50, 200))
            add(Product(3, "Smallen", "Chair", 24.99, 23))
            add(Product(4, "Linnmon", "Table", 40.00, 45))
            add(Product(5, "Lagkapten", "Table", 50.00, 678))
            add(Product(6, "Lack", "Table", 9.99, 68))
            add(Product(7, "Ivar", "Closet", 89.90, 123))
            add(Product(8, "Godishus", "Closet", 89.90, 450))
            add(Product(9, "Metod", "Closet", 227.97, 78))
            add(Product(10, "Soderhamn", "Sofa", 549.00, 90))
            add(Product(11, "Ektorp", "Sofa", 549.90, 120))
            add(Product(12, "Friheten", "Sofa", 499.00, 12))
        }

        val productRecyclerAdapter = ProductRecyclerAdapter()
        productRecyclerAdapter.dataSet
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = productRecyclerAdapter

        val getAlphabetOrder: Button = findViewById(R.id.alphabetOrder)
        getAlphabetOrder.setOnClickListener {
            val sortedByName = productList.sortedBy { it.name }
            productRecyclerAdapter.dataSet = sortedByName
        }

        val getByType: Button = findViewById(R.id.typeSelection)
        getByType.setOnClickListener {
            //TODO()
        }

        val getHigherPrice: Button = findViewById(R.id.higherPrice)
        getHigherPrice.setOnClickListener {
            val sortedByLowerPrice = productList.sortedByDescending { it.price }
            productRecyclerAdapter.dataSet = sortedByLowerPrice
        }

        val getLowerPrice: Button = findViewById(R.id.lowerPrice)
        getLowerPrice.setOnClickListener {
            val sortedByLowerPrice = productList.sortedBy { it.price }
            productRecyclerAdapter.dataSet = sortedByLowerPrice
        }

        val getAmount: Button = findViewById(R.id.amountLeft)
        getAmount.setOnClickListener {
            val sortedByAmount = productList.sortedByDescending { it.quantity }
            productRecyclerAdapter.dataSet = sortedByAmount
        }

    }
}
