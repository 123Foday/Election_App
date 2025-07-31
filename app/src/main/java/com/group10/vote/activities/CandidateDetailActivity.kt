package com.group10.vote.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.group10.vote.R

class CandidateDetailActivity : AppCompatActivity() {
    
    private lateinit var candidateNameText: TextView
    private lateinit var candidatePartyText: TextView
    private lateinit var candidatePositionText: TextView
    private lateinit var candidateManifestoText: TextView
    private lateinit var candidateExperienceText: TextView
    private lateinit var candidateEducationText: TextView
    private lateinit var voteButton: Button
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_candidate_detail)
        
        initializeViews()
        loadCandidateData()
        setupListeners()
    }
    
    private fun initializeViews() {
        candidateNameText = findViewById(R.id.candidateNameText)
        candidatePartyText = findViewById(R.id.candidatePartyText)
        candidatePositionText = findViewById(R.id.candidatePositionText)
        candidateManifestoText = findViewById(R.id.candidateManifestoText)
        candidateExperienceText = findViewById(R.id.candidateExperienceText)
        candidateEducationText = findViewById(R.id.candidateEducationText)
        voteButton = findViewById(R.id.voteButton)
    }
    
    private fun loadCandidateData() {
        val intent = intent
        
        candidateNameText.text = intent.getStringExtra("candidate_name") ?: "Unknown"
        candidatePartyText.text = intent.getStringExtra("candidate_party") ?: "Unknown Party"
        candidatePositionText.text = intent.getStringExtra("candidate_position") ?: "Unknown Position"
        candidateManifestoText.text = intent.getStringExtra("candidate_manifesto") ?: "No manifesto available"
        candidateExperienceText.text = intent.getStringExtra("candidate_experience") ?: "No experience information available"
        candidateEducationText.text = intent.getStringExtra("candidate_education") ?: "No education information available"
    }
    
    private fun setupListeners() {
        voteButton.setOnClickListener {
            val candidateId = intent.getStringExtra("candidate_id") ?: ""
            val candidateName = intent.getStringExtra("candidate_name") ?: ""
            
            // Navigate to voting activity
            val votingIntent = Intent(this, VotingActivity::class.java)
            votingIntent.putExtra("candidate_id", candidateId)
            votingIntent.putExtra("candidate_name", candidateName)
            startActivity(votingIntent)
        }
    }
} 