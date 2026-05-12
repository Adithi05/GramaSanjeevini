package com.example.gramasnjeevini

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_register)

        auth = FirebaseAuth.getInstance()

        val emailEditText = findViewById<EditText>(R.id.emailEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val registerButton = findViewById<Button>(R.id.registerButton)
        val loginText = findViewById<TextView>(R.id.loginText)

        registerButton.setOnClickListener {

            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (email.isEmpty() || password.isEmpty()) {

                Toast.makeText(this,
                    "Fill all fields",
                    Toast.LENGTH_SHORT).show()

            } else {

                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener {

                        if (it.isSuccessful) {

                            Toast.makeText(this,
                                "Registration Successful",
                                Toast.LENGTH_SHORT).show()

                            startActivity(
                                Intent(this, MainActivity::class.java)
                            )

                            finish()

                        } else {

                            Toast.makeText(this,
                                it.exception?.message,
                                Toast.LENGTH_LONG).show()
                        }
                    }
            }
        }

        loginText.setOnClickListener {

            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}