package com.example.gramasnjeevini

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class EmergencyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_emergency)

        // BACK TO HOME BUTTON

        val backButton =
            findViewById<View>(R.id.backHomeButton)

        backButton.setOnClickListener {

            finish()
        }
    }
}