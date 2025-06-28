
package com.fitnessapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "workouts")
data class WorkoutEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val userId: String,
    val date: Long,
    val type: String,
    val duration: Int,
    val caloriesBurned: Int?,
    val notes: String?
)


