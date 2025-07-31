package com.group10.vote.activities

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.group10.vote.R
import com.group10.vote.models.User
import java.util.UUID

class VoterRegistrationActivity : AppCompatActivity() {
    
    private lateinit var fullNameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var phoneNumberEditText: EditText
    private lateinit var dateOfBirthEditText: EditText
    private lateinit var addressEditText: EditText
    private lateinit var nationalIdEditText: EditText
    private lateinit var registerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_voter_registration)
        
        initializeViews()
        setupListeners()
    }
    
    private fun initializeViews() {
        fullNameEditText = findViewById(R.id.fullNameEditText)
        emailEditText = findViewById(R.id.emailEditText)
        phoneNumberEditText = findViewById(R.id.phoneNumberEditText)
        dateOfBirthEditText = findViewById(R.id.dateOfBirthEditText)
        addressEditText = findViewById(R.id.addressEditText)
        nationalIdEditText = findViewById(R.id.nationalIdEditText)
        registerButton = findViewById(R.id.registerButton)
    }
    
    private fun setupListeners() {
        registerButton.setOnClickListener {
            if (validateInputs()) {
                registerVoter()
            }
        }
    }
    
    private fun validateInputs(): Boolean {
        val fullName = fullNameEditText.text.toString().trim()
        val email = emailEditText.text.toString().trim()
        val phoneNumber = phoneNumberEditText.text.toString().trim()
        val dateOfBirth = dateOfBirthEditText.text.toString().trim()
        val address = addressEditText.text.toString().trim()
        val nationalId = nationalIdEditText.text.toString().trim()
        
        if (fullName.isEmpty()) {
            fullNameEditText.error = "Full name is required"
            return false
        }
        
        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEditText.error = "Valid email is required"
            return false
        }
        
        if (phoneNumber.isEmpty()) {
            phoneNumberEditText.error = "Phone number is required"
            return false
        }
        
        if (dateOfBirth.isEmpty()) {
            dateOfBirthEditText.error = "Date of birth is required"
            return false
        }
        
        if (address.isEmpty()) {
            addressEditText.error = "Address is required"
            return false
        }
        
        if (nationalId.isEmpty()) {
            nationalIdEditText.error = "National ID is required"
            return false
        }
        
        return true
    }
    
    private fun registerVoter() {
        val user = User(
            id = UUID.randomUUID().toString(),
            fullName = fullNameEditText.text.toString().trim(),
            email = emailEditText.text.toString().trim(),
            phoneNumber = phoneNumberEditText.text.toString().trim(),
            dateOfBirth = dateOfBirthEditText.text.toString().trim(),
            address = addressEditText.text.toString().trim(),
            nationalId = nationalIdEditText.text.toString().trim(),
            isRegistered = true
        )
        
        // Save user to SharedPreferences for now (in real app, use database)
        val sharedPrefs = getSharedPreferences("VotePlus", MODE_PRIVATE)
        with(sharedPrefs.edit()) {
            putString("user_id", user.id)
            putString("user_full_name", user.fullName)
            putString("user_email", user.email)
            putString("user_phone", user.phoneNumber)
            putString("user_dob", user.dateOfBirth)
            putString("user_address", user.address)
            putString("user_national_id", user.nationalId)
            putBoolean("user_registered", true)
            apply()
        }
        
        Toast.makeText(this, "Registration successful!", Toast.LENGTH_LONG).show()
        finish()
    }
} 