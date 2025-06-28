
package com.fitnessapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.fitnessapp.data.local.entity.ProgressEntryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProgressEntryDao {
    @Insert
    suspend fun insertProgressEntry(entry: ProgressEntryEntity)

    @Update
    suspend fun updateProgressEntry(entry: ProgressEntryEntity)

    @Query("DELETE FROM progress_entries WHERE id = :entryId")
    suspend fun deleteProgressEntry(entryId: Int)

    @Query("SELECT * FROM progress_entries WHERE userId = :userId ORDER BY date DESC")
    fun getProgressEntriesForUser(userId: String): Flow<List<ProgressEntryEntity>>

    @Query("SELECT * FROM progress_entries WHERE id = :entryId")
    suspend fun getProgressEntryById(entryId: Int): ProgressEntryEntity?
}

