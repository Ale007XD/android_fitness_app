
package com.fitnessapp.data

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface HuggingFaceApi {
    @POST("models/{modelId}")
    suspend fun runInference(
        @Header("Authorization") token: String,
        @Body request: InferenceRequest,
        @retrofit2.http.Path("modelId") modelId: String
    ): Response<InferenceResponse>
}

data class InferenceRequest(
    val inputs: String,
    val parameters: Map<String, Any>? = null,
    val options: Map<String, Any>? = null
)

data class InferenceResponse(
    val generated_text: String
)


