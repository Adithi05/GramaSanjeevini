package com.example.gramasnjeevini

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AlertsActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    private lateinit var adapter: AlertsAdapter

    private lateinit var alertList: ArrayList<Alert>

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_alerts)

        recyclerView = findViewById(R.id.alertsRecyclerView)

        recyclerView.layoutManager =
            LinearLayoutManager(this)

        alertList = ArrayList()

        alertList.add(
            Alert(
                "Salbutamol Inhaler",
                "Respiratory",
                "2 days left",
                "14 units",
                "Batch B22109467",
                "₹180",
                "₹90",
                "Ramanagara Sevaka Medicals"
            )
        )

        alertList.add(
            Alert(
                "Paracetamol 500mg",
                "Pain Relief",
                "3 days left",
                "80 units",
                "Batch B1792042",
                "₹2",
                "₹1",
                "Channapatna Care Chemist"
            )
        )

        alertList.add(
            Alert(
                "Anti-Snake Venom",
                "Emergency",
                "6 days left",
                "4 units",
                "Batch B2010954",
                "₹650",
                "₹325",
                "Ramanagara Sevaka Medicals"
            )
        )

        adapter = AlertsAdapter(alertList)

        recyclerView.adapter = adapter
    }
}