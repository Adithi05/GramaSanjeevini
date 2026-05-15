package com.example.gramasnjeevini

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PharmacistLoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_pharmacist_login)

        val email =
            findViewById<EditText>(R.id.pharmacistEmail)

        val password =
            findViewById<EditText>(R.id.pharmacistPassword)

        val loginButton =
            findViewById<Button>(R.id.pharmacistLoginButton)

        val createAccount =
            findViewById<TextView>(R.id.createAccountText)

        loginButton.setOnClickListener {

            val emailText =
                email.text.toString().trim()

            val passwordText =
                password.text.toString().trim()

            if (

                (
                        emailText == "ravi@gmail.com"
                                ||
                                emailText == "meera@gmail.com"
                                ||
                                emailText == "anand@gmail.com"
                        )

                &&

                passwordText == "pharmacy123"

            ) {

                // SAVE LOGIN SESSION

                val sharedPreferences =
                    getSharedPreferences(
                        "PharmacistSession",
                        MODE_PRIVATE
                    )

                sharedPreferences.edit()
                    .putBoolean(
                        "isLoggedIn",
                        true
                    )
                    .apply()

                Toast.makeText(
                    this,
                    "Login Successful",
                    Toast.LENGTH_SHORT
                ).show()

                // OPEN DASHBOARD

                startActivity(
                    Intent(
                        this,
                        PharmacistDashboardActivity::class.java
                    )
                )

                finish()

            } else {

                Toast.makeText(
                    this,
                    "Invalid Credentials",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        // CREATE ACCOUNT

        createAccount.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    RegisterActivity::class.java
                )
            )
        }
    }
}