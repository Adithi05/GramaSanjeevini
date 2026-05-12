package com.example.gramasnjeevini

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class `AdminLoginActivity` : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_pharmacist_login)

        val username =
            findViewById<EditText>(R.id.usernameEditText)

        val password =
            findViewById<EditText>(R.id.passwordEditText)

        val loginButton =
            findViewById<Button>(R.id.loginButton)

        loginButton.setOnClickListener {

            val user = username.text.toString()
            val pass = password.text.toString()

            if (pass == "pharmacy123") {

                Toast.makeText(
                    this,
                    "Welcome $user",
                    Toast.LENGTH_SHORT
                ).show()

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