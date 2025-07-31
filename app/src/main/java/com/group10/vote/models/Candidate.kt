package com.group10.vote.models

data class Candidate(
    val id: String = "",
    val name: String = "",
    val party: String = "",
    val position: String = "",
    val imageUrl: String = "",
    val manifesto: String = "",
    val experience: String = "",
    val education: String = "",
    val voteCount: Int = 0
) 