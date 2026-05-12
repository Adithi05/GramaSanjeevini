package com.example.gramasnjeevini

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PharmacistLoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_admin_login)

        val email =
            findViewById<EditText>(R.id.pharmacistEmail)

        val password =
            findViewById<EditText>(R.id.pharmacistPassword)

        val loginButton =
            findViewById<Button>(R.id.pharmacistLoginButton)

        loginButton.setOnClickListener {

            val emailText = email.text.toString()

            val passwordText = password.text.toString()

            if (
                emailText == "pharmacist@gmail.com"
                &&
                passwordText == "123456"
            ) {

                startActivity(
                    Intent(
                        this,
                        PharmacistDashboardActivity::class.java
                    )
                )

            } else {

                Toast.makeText(
                    this,
                    "Invalid Credentials",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}