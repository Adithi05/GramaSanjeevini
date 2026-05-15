package com.example.gramasnjeevini

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import android.widget.TextView

class HomeFragment : Fragment() {

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

        // VIEW INVENTORY BUTTON 1

        val inventoryBtn1 =
            view.findViewById<View>(R.id.viewInventoryBtn1)

        inventoryBtn1.setOnClickListener {

            startActivity(
                Intent(
                    requireContext(),
                    InventoryActivity::class.java
                )
            )
        }

        // VIEW INVENTORY BUTTON 2

        val inventoryBtn2 =
            view.findViewById<View>(R.id.viewInventoryBtn2)

        inventoryBtn2.setOnClickListener {

            startActivity(
                Intent(
                    requireContext(),
                    InventoryActivity::class.java
                )
            )
        }

        // EMERGENCY LIST BUTTON

        val emergencyBtn =
            view.findViewById<View>(R.id.emergencyListBtn)

        emergencyBtn.setOnClickListener {

            startActivity(
                Intent(
                    requireContext(),
                    EmergencyActivity::class.java
                )
            )
        }

        // SEARCH MEDICINE
        val searchEditText =
            view.findViewById<EditText>(R.id.searchEditText)

        val searchButton =
            view.findViewById<Button>(R.id.searchButton)

        val resultCard =
            view.findViewById<View>(R.id.searchResultCard)

        val resultMedicineName =
            view.findViewById<TextView>(R.id.resultMedicineName)

        val resultStock =
            view.findViewById<TextView>(R.id.resultStock)
        val checkAvailabilityButton =
            view.findViewById<Button>(
                R.id.checkAvailabilityButton
            )

        searchButton.setOnClickListener {

            val medicine =
                searchEditText.text.toString()

            if (medicine.isNotEmpty()) {

                resultCard.visibility = View.VISIBLE

                resultMedicineName.text =
                    medicine + " 500mg"

                resultStock.text =
                    "In Stock (270)"

            } else {

                resultCard.visibility = View.GONE

                Toast.makeText(
                    requireContext(),
                    "Enter medicine name",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        checkAvailabilityButton.setOnClickListener {

            Toast.makeText(
                requireContext(),
                "Medicine available at nearby pharmacies",
                Toast.LENGTH_SHORT
            ).show()

            startActivity(
                Intent(
                    requireContext(),
                    InventoryActivity::class.java
                )
            )
        }
        return view
    }
}