package com.example.gramasnjeevini

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment

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

        // OPEN SIDEBAR

        menuButton.setOnClickListener {

            drawerLayout.openDrawer(GravityCompat.START)
        }

        // CLOSE SIDEBAR

        closeDrawer.setOnClickListener {

            drawerLayout.closeDrawer(GravityCompat.START)
        }

        // DASHBOARD BUTTON

        findViewById<Button>(R.id.dashboardButton)
            .setOnClickListener {

                val sharedPreferences =
                    getSharedPreferences(
                        "PharmacistSession",
                        MODE_PRIVATE
                    )

                val isLoggedIn =
                    sharedPreferences.getBoolean(
                        "isLoggedIn",
                        false
                    )

                if (isLoggedIn) {

                    startActivity(
                        Intent(
                            this,
                            PharmacistDashboardActivity::class.java
                        )
                    )

                } else {

                    startActivity(
                        Intent(
                            this,
                            PharmacistLoginActivity::class.java
                        )
                    )
                }
            }

        // ALERTS BUTTON

        findViewById<Button>(R.id.alertsButton)
            .setOnClickListener {

                startActivity(
                    Intent(
                        this,
                        AlertsActivity::class.java
                    )
                )
            }

        // EMERGENCY BUTTON

        findViewById<Button>(R.id.emergencyButton)
            .setOnClickListener {

                startActivity(
                    Intent(
                        this,
                        EmergencyActivity::class.java
                    )
                )
            }
    }
}