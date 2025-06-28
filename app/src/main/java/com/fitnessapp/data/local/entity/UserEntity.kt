
package com.fitnessapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey val uid: String,
    val email: String?,
    val displayName: String?,
    val age: Int?,
    val gender: String?,
    val height: Double?,
    val currentWeight: Double?,
    val targetWeight: Double?,
    val activityLevel: String?,
    val goals: String? // Storing as String for simplicity, can be converted to List<String>
)


