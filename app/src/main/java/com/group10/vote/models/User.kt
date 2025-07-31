package com.group10.vote.models

data class User(
    val id: String = "",
    val fullName: String = "",
    val email: String = "",
    val phoneNumber: String = "",
    val dateOfBirth: String = "",
    val address: String = "",
    val nationalId: String = "",
    val isRegistered: Boolean = false,
    val hasVoted: Boolean = false
) 