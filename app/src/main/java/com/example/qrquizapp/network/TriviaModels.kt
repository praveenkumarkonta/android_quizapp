package com.example.qrquizapp.network

import com.google.gson.annotations.SerializedName

data class CategoryResponse(
    @SerializedName("trivia_categories") val categories: List<TriviaCategory>
)

data class TriviaCategory(
    val id: Int,
    val name: String
) {
    override fun toString(): String = name // Used directly by Spinner
}

data class QuizResponse(
    @SerializedName("response_code") val responseCode: Int,
    val results: List<QuestionItem>
)

data class QuestionItem(
    val category: String,
    val type: String,
    val difficulty: String,
    val question: String,
    @SerializedName("correct_answer") val correctAnswer: String,
    @SerializedName("incorrect_answers") val incorrectAnswers: List<String>
)