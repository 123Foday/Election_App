package com.group10.vote

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.group10.vote.activities.CandidateListActivity
import com.group10.vote.activities.VoterRegistrationActivity

class MainActivity : AppCompatActivity() {
    
    private lateinit var registerButton: Button
    private lateinit var viewCandidatesButton: Button
    private lateinit var statusText: TextView
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        
        initializeViews()
        setupListeners()
        updateStatus()
    }
    
    override fun onResume() {
        super.onResume()
        updateStatus()
    }
    
    private fun initializeViews() {
        registerButton = findViewById(R.id.registerButton)
        viewCandidatesButton = findViewById(R.id.viewCandidatesButton)
        statusText = findViewById(R.id.statusText)
    }
    
    private fun setupListeners() {
        registerButton.setOnClickListener {
            val intent = Intent(this, VoterRegistrationActivity::class.java)
            startActivity(intent)
        }
        
        viewCandidatesButton.setOnClickListener {
            val intent = Intent(this, CandidateListActivity::class.java)
            startActivity(intent)
        }
    }
    
    private fun updateStatus() {
        val sharedPrefs = getSharedPreferences("VotePlus", MODE_PRIVATE)
        val isRegistered = sharedPrefs.getBoolean("user_registered", false)
        val hasVoted = sharedPrefs.getBoolean("user_has_voted", false)
        
        if (isRegistered) {
            if (hasVoted) {
                statusText.text = "✅ You are registered and have voted"
                statusText.setTextColor(getColor(android.R.color.holo_green_dark))
            } else {
                statusText.text = "✅ You are registered - Ready to vote"
                statusText.setTextColor(getColor(android.R.color.holo_blue_dark))
            }
        } else {
            statusText.text = "❌ Please register as a voter first"
            statusText.setTextColor(getColor(android.R.color.holo_red_dark))
        }
    }
}