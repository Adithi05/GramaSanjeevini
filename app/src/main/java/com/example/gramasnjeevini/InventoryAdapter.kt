package com.example.gramasnjeevini

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class InventoryAdapter(
    private val inventoryList: ArrayList<Inventory>
) : RecyclerView.Adapter<InventoryAdapter.ViewHolder>() {

    class ViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView) {

        val medicineName: TextView =
            itemView.findViewById(R.id.inventoryMedicineName)

        val category: TextView =
            itemView.findViewById(R.id.inventoryCategory)

        val price: TextView =
            itemView.findViewById(R.id.inventoryPrice)

        val stock: TextView =
            itemView.findViewById(R.id.inventoryStock)

        val expiry: TextView =
            itemView.findViewById(R.id.inventoryExpiry)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_inventory, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {

        val item = inventoryList[position]

        holder.medicineName.text =
            item.name

        holder.category.text =
            "${item.dosage_form} • ${item.category}"

        holder.price.text =
            "₹${item.price}"

        holder.stock.text =
            "Stock: ${item.stock}"

        holder.expiry.text =
            "Exp: ${item.expiry}"
    }

    override fun getItemCount(): Int {

        return inventoryList.size
    }
}