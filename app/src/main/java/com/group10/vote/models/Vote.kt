package com.group10.vote.models

data class Vote(
    val id: String = "",
    val userId: String = "",
    val candidateId: String = "",
    val timestamp: Long = 0L
) 