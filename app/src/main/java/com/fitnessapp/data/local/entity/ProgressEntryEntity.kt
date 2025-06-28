
package com.fitnessapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "progress_entries")
data class ProgressEntryEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val userId: String,
    val date: Long,
    val weight: Double,
    val bodyFat: Double?,
    val measurements: String? // Storing as String for simplicity, can be converted to a more complex type
)


