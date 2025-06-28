
package com.fitnessapp.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HuggingFaceClient(private val apiKey: String) {

    private val BASE_URL = "https://api-inference.huggingface.co/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val huggingFaceApi: HuggingFaceApi = retrofit.create(HuggingFaceApi::class.java)

    suspend fun generateWorkoutPlan(prompt: String, modelId: String): String? {
        val request = InferenceRequest(inputs = prompt)
        val response = huggingFaceApi.runInference("Bearer $apiKey", request, modelId)
        return if (response.isSuccessful) {
            response.body()?.generated_text
        } else {
            null
        }
    }

    suspend fun getAiAdvice(prompt: String, modelId: String): String? {
        val request = InferenceRequest(inputs = prompt)
        val response = huggingFaceApi.runInference("Bearer $apiKey", request, modelId)
        return if (response.isSuccessful) {
            response.body()?.generated_text
        } else {
            null
        }
    }
}

