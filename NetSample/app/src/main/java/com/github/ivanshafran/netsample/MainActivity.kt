package com.github.ivanshafran.netsample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.github.ivanshafran.netsample.httpurlconnection.HttpUrlConnectionActivity
import com.github.ivanshafran.netsample.okhttp.OkHttpActivity
import com.github.ivanshafran.netsample.retrofit.RetrofitActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.http_url_connection_button).setOnClickListener {
            startActivity(Intent(this, HttpUrlConnectionActivity::class.java))
        }

        findViewById<View>(R.id.okhttp_button).setOnClickListener {
            startActivity(Intent(this, OkHttpActivity::class.java))
        }

        findViewById<View>(R.id.retrofit_button).setOnClickListener {
            startActivity(Intent(this, RetrofitActivity::class.java))
        }
    }
}
