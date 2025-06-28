
package com.fitnessapp.data

import com.fitnessapp.data.model.User

class AiAdviceRepository(private val huggingFaceClient: HuggingFaceClient) {

    private val AI_ADVICE_MODEL_ID = "google/flan-t5-base"

    suspend fun getPersonalizedAiAdvice(user: User, context: String): String? {
        val prompt = "Предоставь персонализированный совет по фитнесу или питанию для пользователя с следующими данными: " +
                "Возраст: ${user.age}, Пол: ${user.gender}, Текущий вес: ${user.currentWeight} кг, " +
                "Целевой вес: ${user.targetWeight} кг, Уровень активности: ${user.activityLevel}, " +
                "Цели: ${user.goals?.joinToString(", ")}. " +
                "Контекст запроса: $context. " +
                "Совет должен быть кратким и мотивирующим."

        return huggingFaceClient.getAiAdvice(prompt, AI_ADVICE_MODEL_ID)
    }
}

