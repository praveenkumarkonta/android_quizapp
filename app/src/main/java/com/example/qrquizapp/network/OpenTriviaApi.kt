package com.example.qrquizapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenTriviaApi {
    @GET("api_category.php")
    suspend fun getCategories(): CategoryResponse

    @GET("api.php")
    suspend fun getQuestions(
        @Query("amount") amount: Int = 10,
        @Query("category") category: Int,
        @Query("difficulty") difficulty: String,
        @Query("type") type: String = "multiple"
    ): QuizResponse

    companion object {
        private const val BASE_URL = "https://opentdb.com/"

        val instance: OpenTriviaApi by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(OpenTriviaApi::class.java)
        }
    }
}