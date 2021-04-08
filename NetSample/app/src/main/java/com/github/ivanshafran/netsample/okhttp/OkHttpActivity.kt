package com.github.ivanshafran.netsample.okhttp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.github.ivanshafran.netsample.R
import kotlinx.coroutines.*
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject

class OkHttpActivity : AppCompatActivity() {

    private val scope = MainScope()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ok_http)
        val textView = findViewById<TextView>(R.id.okhttp_result)

        scope.launch {
            textView.text = "Loading..."
            textView.text = load()
        }
    }

    @Suppress("BlockingMethodInNonBlockingContext")
    suspend fun load(): String = withContext(Dispatchers.IO) {
        val okHttp = OkHttpClient()
        val request = Request
            .Builder()
            .url("https://api.stackexchange.com/2.2/questions?page=1&pagesize=100&order=asc&sort=creation&tagged=Android&site=stackoverflow")
            .build()

        val response = okHttp.newCall(request).execute()
        if (response.isSuccessful) {
            val value = response.body()?.string() ?: return@withContext ""
            val jsonObject = JSONObject(value)
            return@withContext jsonObject
                .getJSONArray("items")
                .getJSONObject(0)
                .getString("title")
        } else {
            return@withContext "error"
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }
}
