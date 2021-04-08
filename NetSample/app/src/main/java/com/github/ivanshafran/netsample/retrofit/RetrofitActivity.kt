package com.github.ivanshafran.netsample.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.github.ivanshafran.netsample.R
import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitActivity : AppCompatActivity() {

    private val scope = MainScope()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)

        val textView = findViewById<TextView>(R.id.retrofit_text)
        scope.launch {
            textView.text = "Loading..."
            textView.text = load()
        }
    }

    private suspend fun load(): String = withContext(Dispatchers.IO) {
        val retrofit = Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.stackexchange.com/2.2/")
            .build()

        val api = retrofit.create(Api::class.java)
        val questionResponse = api.getQuestions()
        val items = questionResponse ?: return@withContext ""
        val stringBuilder = StringBuilder()
        for (question in items.items) {
            stringBuilder
                .append("title: ").append(question.title).append("\n")
                .append("isAnswered: ").append(question.isAnswered).append("\n\n")
        }
        return@withContext stringBuilder.toString()
    }

    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }
}
