package com.group10.vote.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.group10.vote.MainActivity
import com.group10.vote.R
import java.util.UUID

class VotingActivity : AppCompatActivity() {
    
    private lateinit var candidateNameText: TextView
    private lateinit var confirmVoteButton: Button
    private lateinit var cancelButton: Button
    
    private var candidateId: String = ""
    private var candidateName: String = ""
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_voting)
        
        initializeViews()
        loadCandidateData()
        setupListeners()
    }
    
    private fun initializeViews() {
        candidateNameText = findViewById(R.id.candidateNameText)
        confirmVoteButton = findViewById(R.id.confirmVoteButton)
        cancelButton = findViewById(R.id.cancelButton)
    }
    
    private fun loadCandidateData() {
        val intent = intent
        candidateId = intent.getStringExtra("candidate_id") ?: ""
        candidateName = intent.getStringExtra("candidate_name") ?: "Unknown"
        
        candidateNameText.text = "Are you sure you want to vote for $candidateName?"
    }
    
    private fun setupListeners() {
        confirmVoteButton.setOnClickListener {
            showVoteConfirmationDialog()
        }
        
        cancelButton.setOnClickListener {
            finish()
        }
    }
    
    private fun showVoteConfirmationDialog() {
        AlertDialog.Builder(this)
            .setTitle("Confirm Your Vote")
            .setMessage("You are about to vote for $candidateName. This action cannot be undone. Are you sure?")
            .setPositiveButton("Yes, Vote") { _, _ ->
                castVote()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
    
    private fun castVote() {
        // Check if user is registered
        val sharedPrefs = getSharedPreferences("VotePlus", MODE_PRIVATE)
        val isRegistered = sharedPrefs.getBoolean("user_registered", false)
        
        if (!isRegistered) {
            Toast.makeText(this, "You must register as a voter first!", Toast.LENGTH_LONG).show()
            val intent = Intent(this, VoterRegistrationActivity::class.java)
            startActivity(intent)
            return
        }
        
        // Check if user has already voted
        val hasVoted = sharedPrefs.getBoolean("user_has_voted", false)
        if (hasVoted) {
            Toast.makeText(this, "You have already voted in this election!", Toast.LENGTH_LONG).show()
            finish()
            return
        }
        
        // Record the vote
        val voteId = UUID.randomUUID().toString()
        val userId = sharedPrefs.getString("user_id", "") ?: ""
        val timestamp = System.currentTimeMillis()
        
        // Save vote to SharedPreferences (in real app, save to database)
        with(sharedPrefs.edit()) {
            putString("vote_id", voteId)
            putString("vote_user_id", userId)
            putString("vote_candidate_id", candidateId)
            putLong("vote_timestamp", timestamp)
            putBoolean("user_has_voted", true)
            apply()
        }
        
        // Show success message
        AlertDialog.Builder(this)
            .setTitle("Vote Cast Successfully!")
            .setMessage("Your vote for $candidateName has been recorded. Thank you for participating in the democratic process!")
            .setPositiveButton("OK") { _, _ ->
                // Navigate back to main activity
                val intent = Intent(this, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
                finish()
            }
            .setCancelable(false)
            .show()
    }
} 