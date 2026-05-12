package com.example.gramasnjeevini

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        // LOAD HOME FRAGMENT

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, HomeFragment())
            .commit()

        // DRAWER

        val drawerLayout =
            findViewById<DrawerLayout>(R.id.drawerLayout)

        val menuButton =
            findViewById<ImageButton>(R.id.menuButton)

        val closeDrawer =
            findViewById<ImageButton>(R.id.closeDrawer)

        menuButton.setOnClickListener {

            drawerLayout.openDrawer(GravityCompat.START)
        }

        closeDrawer.setOnClickListener {

            drawerLayout.closeDrawer(GravityCompat.START)
        }
        val alertsButton =
            findViewById<Button>(R.id.alertsButton)

        alertsButton.setOnClickListener {

            startActivity(
                Intent(this, AlertsActivity::class.java)
            )
        }

        val locationSpinner =
            findViewById<Spinner>(R.id.locationSpinner)

        val languageSpinner =
            findViewById<Spinner>(R.id.languageSpinner)

        val locationAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.locations,
            android.R.layout.simple_spinner_dropdown_item
        )

        locationSpinner.adapter = locationAdapter

        val languageAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.languages,
            android.R.layout.simple_spinner_dropdown_item
        )

        languageSpinner.adapter = languageAdapter



    }
}