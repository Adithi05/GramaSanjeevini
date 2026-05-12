package com.example.gramasnjeevini

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.Locale

class MedicineAdapter(private val medicineList: ArrayList<Medicine>) :
    RecyclerView.Adapter<MedicineAdapter.MedicineViewHolder>() {

    private var filteredList = ArrayList<Medicine>()

    init {
        filteredList.addAll(medicineList)
    }

    class MedicineViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val medicineName: TextView =
            itemView.findViewById(R.id.medicineName)

        val medicineAvailability: TextView =
            itemView.findViewById(R.id.medicineAvailability)

        val medicinePrice: TextView =
            itemView.findViewById(R.id.medicinePrice)

        val medicineDosage: TextView =
            itemView.findViewById(R.id.medicineDosage)

        val medicineManufacturer: TextView =
            itemView.findViewById(R.id.medicineManufacturer)

        val medicinePharmacy: TextView =
            itemView.findViewById(R.id.medicinePharmacy)

        val medicineDescription: TextView =
            itemView.findViewById(R.id.medicineDescription)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MedicineViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_medicine, parent, false)

        return MedicineViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: MedicineViewHolder,
        position: Int
    ) {

        val medicine = filteredList[position]

        holder.medicineName.text = medicine.name
        holder.medicineAvailability.text =
            "Status: ${medicine.availability}"

        holder.medicinePrice.text =
            "Price: ${medicine.price}"

        holder.medicineDosage.text =
            "Dosage: ${medicine.dosage}"

        holder.medicineManufacturer.text =
            "Manufacturer: ${medicine.manufacturer}"

        holder.medicinePharmacy.text =
            "Pharmacy: ${medicine.pharmacy}"

        holder.medicineDescription.text =
            medicine.description
    }

    override fun getItemCount(): Int {
        return filteredList.size
    }

    fun filter(query: String) {

        filteredList.clear()

        if (query.isEmpty()) {

            filteredList.addAll(medicineList)

        } else {

            val searchText =
                query.lowercase(Locale.getDefault())

            for (medicine in medicineList) {

                if (medicine.name
                        .lowercase(Locale.getDefault())
                        .contains(searchText)
                ) {

                    filteredList.add(medicine)
                }
            }
        }

        notifyDataSetChanged()
    }
}