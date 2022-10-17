package com.example.theonlineshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val productList = ArrayList<Product>()
        productList.add(Product(1, "Tobias", "Chair", 89.90, 153))
        productList.add(Product(2, "Adde", "Chair", 15.50, 200))
        productList.add(Product(3, "Smallen", "Chair", 24.99, 23))
        productList.add(Product(4, "Linnmon", "Table", 40.00, 45))
        productList.add(Product(5, "Lagkapten", "Table", 50.00, 678))
        productList.add(Product(6, "Lack", "Table", 9.99, 68))
        productList.add(Product(7, "Ivar", "Closet", 89.90, 123))
        productList.add(Product(8, "Godishus", "Closet", 89.90, 450))
        productList.add(Product(9, "Metod", "Closet", 227.97, 78))
        productList.add(Product(10, "Soderhamn", "Sofa", 549.00, 90))
        productList.add(Product(11, "Ektorp", "Sofa", 549.90, 120))
        productList.add(Product(12, "Friheten", "Sofa", 499.00, 12))

        val productRecyclerAdapter = ProductRecyclerAdapter()
        productRecyclerAdapter.setData(productList)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = productRecyclerAdapter

        val getAlphabetOrder: Button = findViewById(R.id.alphabet_order)
        getAlphabetOrder.setOnClickListener {
            val sortedByName = productList.sortedBy { it.name }
            productRecyclerAdapter.setData(sortedByName)
        }

        val getByType:Button=findViewById(R.id.type_selection)
        getByType.setOnClickListener {
            TODO()
        }

        val getHigherPrice: Button = findViewById(R.id.higher_price)
        getHigherPrice.setOnClickListener {
            val sortedByLowerPrice = productList.sortedByDescending { it.price }
            productRecyclerAdapter.setData(sortedByLowerPrice)
        }

        val getLowerPrice: Button = findViewById(R.id.lower_price)
        getLowerPrice.setOnClickListener {
            val sortedByLowerPrice = productList.sortedBy { it.price }
            productRecyclerAdapter.setData(sortedByLowerPrice)
        }

        val getAmount: Button = findViewById(R.id.amount_left)
        getAmount.setOnClickListener {
            val sortedByAmount = productList.sortedByDescending { it.quantity }
            productRecyclerAdapter.setData(sortedByAmount)
        }

    }
}
