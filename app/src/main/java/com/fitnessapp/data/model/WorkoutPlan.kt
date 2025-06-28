
package com.fitnessapp.data.model

data class WorkoutPlan(
    val id: String,
    val userId: String,
    val name: String,
    val description: String,
    val exercises: List<Exercise>,
    val durationMinutes: Int,
    val difficulty: String
)

data class Exercise(
    val name: String,
    val sets: Int,
    val reps: String,
    val weight: String? = null,
    val durationSeconds: Int? = null,
    val notes: String? = null
)


