package com.example.gramasnjeevini

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PharmacyAdapter(
    private val pharmacyList: ArrayList<Pharmacy>
) : RecyclerView.Adapter<PharmacyAdapter.ViewHolder>() {

    class ViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView) {

        val pharmacyName: TextView =
            itemView.findViewById(R.id.pharmacyName)

        val pharmacyLocation: TextView =
            itemView.findViewById(R.id.pharmacyLocation)

        val pharmacyTiming: TextView =
            itemView.findViewById(R.id.pharmacyTiming)

        val pharmacyPhone: TextView =
            itemView.findViewById(R.id.pharmacyPhone)

        val viewInventoryButton: Button =
            itemView.findViewById(R.id.viewInventoryButton)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pharmacy, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {

        val pharmacy = pharmacyList[position]

        holder.pharmacyName.text =
            pharmacy.name

        holder.pharmacyLocation.text =
            "📍 ${pharmacy.location}"

        holder.pharmacyTiming.text =
            "🕒 ${pharmacy.hours}"

        holder.pharmacyPhone.text =
            "📞 ${pharmacy.phone}"

        holder.viewInventoryButton.setOnClickListener {

            val context = holder.itemView.context

            val intent =
                Intent(context, InventoryActivity::class.java)

            intent.putExtra(
                "pharmacyId",
                pharmacy.id
            )

            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {

        return pharmacyList.size
    }
}