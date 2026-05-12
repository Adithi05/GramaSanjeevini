package com.example.gramasnjeevini

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AlertsAdapter(
    private val alertList: ArrayList<Alert>
) : RecyclerView.Adapter<AlertsAdapter.AlertViewHolder>() {

    class AlertViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView) {

        val medicineName: TextView =
            itemView.findViewById(R.id.medicineName)

        val category: TextView =
            itemView.findViewById(R.id.category)

        val daysLeft: TextView =
            itemView.findViewById(R.id.daysLeft)

        val units: TextView =
            itemView.findViewById(R.id.units)

        val batch: TextView =
            itemView.findViewById(R.id.batch)

        val oldPrice: TextView =
            itemView.findViewById(R.id.oldPrice)

        val newPrice: TextView =
            itemView.findViewById(R.id.newPrice)

        val pharmacy: TextView =
            itemView.findViewById(R.id.pharmacy)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AlertViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.alert_item, parent, false)

        return AlertViewHolder(view)
    }

    override fun getItemCount(): Int {
        return alertList.size
    }

    override fun onBindViewHolder(
        holder: AlertViewHolder,
        position: Int
    ) {

        val alert = alertList[position]

        holder.medicineName.text = alert.medicineName
        holder.category.text = alert.category
        holder.daysLeft.text = alert.daysLeft
        holder.units.text = alert.units
        holder.batch.text = alert.batch
        holder.oldPrice.text = alert.oldPrice
        holder.newPrice.text = alert.newPrice
        holder.pharmacy.text = alert.pharmacy
    }
}