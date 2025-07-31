package com.group10.vote.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.group10.vote.R
import com.group10.vote.models.Candidate

class CandidateAdapter(
    private val candidates: List<Candidate>,
    private val onCandidateClick: (Candidate) -> Unit
) : RecyclerView.Adapter<CandidateAdapter.CandidateViewHolder>() {

    class CandidateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val candidateImage: ImageView = itemView.findViewById(R.id.candidateImage)
        val candidateName: TextView = itemView.findViewById(R.id.candidateName)
        val candidateParty: TextView = itemView.findViewById(R.id.candidateParty)
        val candidatePosition: TextView = itemView.findViewById(R.id.candidatePosition)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CandidateViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_candidate, parent, false)
        return CandidateViewHolder(view)
    }

    override fun onBindViewHolder(holder: CandidateViewHolder, position: Int) {
        val candidate = candidates[position]
        
        holder.candidateName.text = candidate.name
        holder.candidateParty.text = candidate.party
        holder.candidatePosition.text = candidate.position
        
        // Set default image for now (you can add image loading library later)
        holder.candidateImage.setImageResource(R.drawable.ic_person)
        
        holder.itemView.setOnClickListener {
            onCandidateClick(candidate)
        }
    }

    override fun getItemCount(): Int = candidates.size
} 