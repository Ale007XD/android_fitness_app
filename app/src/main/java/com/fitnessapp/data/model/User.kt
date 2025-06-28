
package com.fitnessapp.data.model

data class User(
    val uid: String,
    val email: String?,
    val displayName: String?,
    val age: Int? = null,
    val gender: String? = null,
    val height: Double? = null,
    val currentWeight: Double? = null,
    val targetWeight: Double? = null,
    val activityLevel: String? = null,
    val goals: List<String>? = null
)


