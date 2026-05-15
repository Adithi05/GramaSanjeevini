package com.example.gramasnjeevini

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class PharmacistDashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(
            R.layout.activity_pharmacist_dashboard
        )

        // ADD MEDICINE BUTTON

        val addMedicineButton =
            findViewById<Button>(R.id.addMedicineButton)

        addMedicineButton.setOnClickListener {

            val dialogView =
                layoutInflater.inflate(
                    R.layout.dialog_add_medicine,
                    null
                )

            val medicineSpinner =
                dialogView.findViewById<Spinner>(
                    R.id.medicineSpinner
                )

            val medicines = arrayOf(
                "Paracetamol",
                "Dolo 650",
                "ORS",
                "Insulin",
                "Amoxicillin"
            )

            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                medicines
            )

            medicineSpinner.adapter = adapter

            AlertDialog.Builder(this)
                .setTitle("Add Medicine")
                .setView(dialogView)

                .setPositiveButton(
                    "Add Medicine"
                ) { _, _ ->

                    Toast.makeText(
                        this,
                        "Medicine Added Successfully",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                .setNegativeButton(
                    "Cancel",
                    null
                )

                .show()
        }

        // UPDATE STOCK BUTTON

        val updateStockButton =
            findViewById<Button>(R.id.updateStockButton)

        updateStockButton.setOnClickListener {

            Toast.makeText(
                this,
                "Stock Updated Successfully",
                Toast.LENGTH_SHORT
            ).show()
        }

        // SIGN OUT BUTTON

        val signOutButton =
            findViewById<Button>(R.id.signOutButton)

        signOutButton.setOnClickListener {

            val sharedPreferences =
                getSharedPreferences(
                    "PharmacistSession",
                    MODE_PRIVATE
                )

            sharedPreferences.edit()
                .clear()
                .apply()

            startActivity(
                Intent(
                    this,
                    MainActivity::class.java
                )
            )

            finish()
        }
    }
}