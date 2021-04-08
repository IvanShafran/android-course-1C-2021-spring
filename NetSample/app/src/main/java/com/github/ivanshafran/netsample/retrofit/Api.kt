package com.github.ivanshafran.netsample.retrofit

import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.GET

class Items(
    @SerializedName("items") val items: List<Question>
)

class Question(
    @SerializedName("title") val title: String,
    @SerializedName("is_answered") val isAnswered: Boolean?
)

interface Api {

    @GET("questions?page=1&pagesize=100&order=asc&sort=creation&tagged=Android&site=stackoverflow")
    suspend fun getQuestions(): Items
}
