
package com.fitnessapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.fitnessapp.data.local.dao.MealDao
import com.fitnessapp.data.local.dao.ProgressEntryDao
import com.fitnessapp.data.local.dao.UserDao
import com.fitnessapp.data.local.dao.WorkoutDao
import com.fitnessapp.data.local.entity.MealEntity
import com.fitnessapp.data.local.entity.ProgressEntryEntity
import com.fitnessapp.data.local.entity.UserEntity
import com.fitnessapp.data.local.entity.WorkoutEntity

@Database(
    entities = [
        UserEntity::class,
        WorkoutEntity::class,
        MealEntity::class,
        ProgressEntryEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun workoutDao(): WorkoutDao
    abstract fun mealDao(): MealDao
    abstract fun progressEntryDao(): ProgressEntryDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "fitness_app_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}

