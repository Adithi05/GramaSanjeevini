package com.example.gramasnjeevini

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore

class InventoryActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    private lateinit var adapter: InventoryAdapter

    private lateinit var inventoryList: ArrayList<Inventory>

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_inventory)

        recyclerView =
            findViewById(R.id.inventoryRecyclerView)

        recyclerView.layoutManager =
            LinearLayoutManager(this)

        inventoryList = ArrayList()

        adapter = InventoryAdapter(inventoryList)

        recyclerView.adapter = adapter

        loadInventory()
    }

    private fun loadInventory() {

        FirebaseFirestore.getInstance()
            .collection("inventory")
            .get()
            .addOnSuccessListener { result ->

                inventoryList.clear()

                for (document in result) {

                    val name =
                        document.getString("name") ?: ""

                    val stock =
                        document.get("stock").toString()

                    val price =
                        document.get("price").toString()

                    val expiry =
                        document.getString("expiry") ?: ""

                    val item = Inventory(

                        name =
                            document.getString("name") ?: "",

                        category =
                            document.getString("category") ?: "",

                        dosage_form =
                            document.getString("dosage_form") ?: "",

                        stock =
                            document.get("stock").toString(),

                        price =
                            document.get("price").toString(),

                        expiry =
                            document.getString("expiry") ?: ""
                    )

                    inventoryList.add(item)
                }

                adapter.notifyDataSetChanged()
            }
    }
}