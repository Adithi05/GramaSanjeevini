package com.example.gramasnjeevini

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PharmacyFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PharmacyAdapter
    private lateinit var pharmacyList: ArrayList<Pharmacy>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_pharmacy, container, false)

        recyclerView = view.findViewById(R.id.pharmacyRecyclerView)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        pharmacyList = ArrayList()


        pharmacyList.add(
            Pharmacy(
                1,
                "Bidadi Jana Aushadhi Kendra",
                "Bidadi, Ramanagara",
                "8:00 AM - 9:00 PM",
                "+91 9876543210"
            )
        )

        pharmacyList.add(
            Pharmacy(
                2,
                "Ramanagara Sevaka Medicals",
                "Kengeri, Bangalore",
                "9:00 AM - 10:00 PM",
                "+91 9876500000"
            )
        )

        pharmacyList.add(
            Pharmacy(
                3,
                "Magadi Health Mart",
                "Magadi, Ramanagara",
                "24 Hours",
                "+91 9988776655"
            )
        )



        adapter = PharmacyAdapter(pharmacyList)

        recyclerView.adapter = adapter

        return view
    }
}