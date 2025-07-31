package com.group10.vote.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.group10.vote.R
import com.group10.vote.adapters.CandidateAdapter
import com.group10.vote.models.Candidate

class CandidateListActivity : AppCompatActivity() {
    
    private lateinit var recyclerView: RecyclerView
    private lateinit var candidateAdapter: CandidateAdapter
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_candidate_list)
        
        setupRecyclerView()
        loadCandidates()
    }
    
    private fun setupRecyclerView() {
        recyclerView = findViewById(R.id.candidatesRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        
        candidateAdapter = CandidateAdapter(emptyList()) { candidate ->
            // Navigate to candidate detail activity
            val intent = Intent(this, CandidateDetailActivity::class.java)
            intent.putExtra("candidate_id", candidate.id)
            intent.putExtra("candidate_name", candidate.name)
            intent.putExtra("candidate_party", candidate.party)
            intent.putExtra("candidate_position", candidate.position)
            intent.putExtra("candidate_manifesto", candidate.manifesto)
            intent.putExtra("candidate_experience", candidate.experience)
            intent.putExtra("candidate_education", candidate.education)
            startActivity(intent)
        }
        
        recyclerView.adapter = candidateAdapter
    }
    
    private fun loadCandidates() {
        // Sample candidates data (in real app, this would come from API/database)
        val candidates = listOf(
            Candidate(
                id = "1",
                name = "Emilia Komba",
                party = "Cybersecurity Party",
                position = "Group Leader",
                manifesto = "I believe in creating opportunities for all citizens through education, healthcare, and economic growth. My vision is to build a stronger, more inclusive society where everyone has the chance to succeed.",
                experience = "• Mayor of Springfield (2018-2022)\n• State Senator (2014-2018)\n• City Council Member (2010-2014)",
                education = "• Master's in Public Administration, Harvard University\n• Bachelor's in Political Science, State University"
            ),
            Candidate(
                id = "2",
                name = "Kai Foday",
                party = "SW Engineering Party",
                position = "Software Engineer",
                manifesto = "My focus is on economic freedom, national security, and traditional values. I will work to reduce government spending, strengthen our borders, and protect our constitutional rights.",
                experience = "• Governor of Texas (2019-2023)\n• Lieutenant Governor (2015-2019)\n• State Representative (2011-2015)",
                education = "• Juris Doctor, Yale Law School\n• Bachelor's in Economics, University of Texas"
            ),
            Candidate(
                id = "3",
                name = "Ernest B Kamara",
                party = "AI and Machine Learning Party",
                position = "Data Scientist",
                manifesto = "I represent the voice of the people, not political parties. My platform focuses on climate action, healthcare reform, and campaign finance reform to restore democracy.",
                experience = "• Environmental Activist (2015-2023)\n• Non-profit Director (2010-2015)\n• Community Organizer (2008-2010)",
                education = "• Master's in Environmental Science, Stanford University\n• Bachelor's in Biology, UC Berkeley"
            ),
            Candidate(
                id = "4",
                name = "Engr Brato Kamara",
                party = "Computer Science Party",
                position = "Best Lecturer",
                manifesto = "I stand for environmental justice, social equality, and peace. My administration will prioritize renewable energy, universal healthcare, and ending systemic racism.",
                experience = "• Environmental Lawyer (2016-2023)\n• Civil Rights Advocate (2012-2016)\n• Community Organizer (2008-2012)",
                education = "• Juris Doctor, Columbia Law School\n• Bachelor's in Environmental Studies,  University of Makeni"
            )
        )
        
        candidateAdapter = CandidateAdapter(candidates) { candidate ->
            val intent = Intent(this, CandidateDetailActivity::class.java)
            intent.putExtra("candidate_id", candidate.id)
            intent.putExtra("candidate_name", candidate.name)
            intent.putExtra("candidate_party", candidate.party)
            intent.putExtra("candidate_position", candidate.position)
            intent.putExtra("candidate_manifesto", candidate.manifesto)
            intent.putExtra("candidate_experience", candidate.experience)
            intent.putExtra("candidate_education", candidate.education)
            startActivity(intent)
        }
        
        recyclerView.adapter = candidateAdapter
    }
} 