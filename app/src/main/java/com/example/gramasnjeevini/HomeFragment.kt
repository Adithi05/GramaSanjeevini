package com.example.gramasnjeevini

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore

class HomeFragment : Fragment() {

    // PHARMACY

    private lateinit var pharmacyRecyclerView: RecyclerView
    private lateinit var pharmacyAdapter: PharmacyAdapter
    private lateinit var pharmacyList: ArrayList<Pharmacy>

    // MEDICINES



    private lateinit var firestore: FirebaseFirestore

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =
            inflater.inflate(
                R.layout.fragment_home,
                container,
                false
            )

        firestore = FirebaseFirestore.getInstance()

        // MEDICINE RECYCLER VIEW



        // PHARMACY RECYCLER VIEW

        pharmacyRecyclerView =
            view.findViewById(R.id.pharmacyRecyclerView)

        pharmacyRecyclerView.layoutManager =
            LinearLayoutManager(requireContext())

        pharmacyList = ArrayList()

        pharmacyAdapter = PharmacyAdapter(pharmacyList)

        pharmacyRecyclerView.adapter = pharmacyAdapter

        // LOAD DATA



        loadPharmacies()

        // EMERGENCY CARD

        val emergencyCard =
            view.findViewById<View>(R.id.emergencyCard)

        emergencyCard.setOnClickListener {

            startActivity(
                Intent(
                    requireContext(),
                    EmergencyActivity::class.java
                )
            )
        }



        return view
    }

    // LOAD MEDICINES



    // LOAD PHARMACIES

    private fun loadPharmacies() {

        firestore.collection("pharmacies")
            .get()
            .addOnSuccessListener { result ->

                pharmacyList.clear()

                for (document in result) {

                    val pharmacy =
                        document.toObject(Pharmacy::class.java)



                    pharmacyList.add(pharmacy)
                }

                pharmacyAdapter.notifyDataSetChanged()
            }
    }
}