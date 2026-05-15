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






        adapter = PharmacyAdapter(pharmacyList)

        recyclerView.adapter = adapter

        return view
    }
}