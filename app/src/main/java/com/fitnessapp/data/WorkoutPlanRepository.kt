
package com.fitnessapp.data

import com.fitnessapp.data.model.User
import com.fitnessapp.data.model.WorkoutPlan
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class WorkoutPlanRepository(private val huggingFaceClient: HuggingFaceClient) {

    // Placeholder for a more sophisticated model. You would typically use a fine-tuned model
    // for workout plan generation.
    private val WORKOUT_PLAN_MODEL_ID = "google/flan-t5-base"

    suspend fun generatePersonalizedWorkoutPlan(user: User): WorkoutPlan? {
        val prompt = "Создай персонализированный план тренировок для пользователя с следующими данными: " +
                "Возраст: ${user.age}, Пол: ${user.gender}, Текущий вес: ${user.currentWeight} кг, " +
                "Целевой вес: ${user.targetWeight} кг, Уровень активности: ${user.activityLevel}, " +
                "Цели: ${user.goals?.joinToString(", ")}. " +
                "План должен быть в формате JSON, содержащий поля: id, userId, name, description, exercises (массив объектов с полями name, sets, reps, weight, durationSeconds, notes), durationMinutes, difficulty."

        val generatedText = huggingFaceClient.generateWorkoutPlan(prompt, WORKOUT_PLAN_MODEL_ID)

        return generatedText?.let {
            try {
                // Attempt to parse the generated text as a WorkoutPlan object
                // This might require some post-processing of the generated text to fit the JSON format
                // For a real application, you'd want a more robust parsing or a model that directly outputs valid JSON
                Gson().fromJson(it, WorkoutPlan::class.java)
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }
        }
    }
}

