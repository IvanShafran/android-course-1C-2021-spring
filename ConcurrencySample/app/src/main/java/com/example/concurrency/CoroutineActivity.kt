package com.example.concurrency

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import kotlinx.coroutines.*

class CoroutineActivity : AppCompatActivity() {

    fun getIntent(context: Context): Intent? {
        return Intent(context, CoroutineActivity::class.java)
    }

    private lateinit var progressBar: ProgressBar
    private lateinit var textView: TextView
    private val coroutineScope = MainScope()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sample)
        progressBar = findViewById(R.id.progressBar)
        textView = findViewById(R.id.textView)
    }

    override fun onResume() {
        super.onResume()

        coroutineScope.launch {
            progressBar.visibility = View.VISIBLE // main
            val result = withContext(Dispatchers.IO) { // Запуск корутины на фоновом поток + ожидание результата(прерывание) на главном
                TheMostImportantQuestionSolver.solve(10) // фоновый поток
            }
            textView.text = "Result: $result" // main
            progressBar.visibility = View.GONE // main
        }
    }

    override fun onPause() {
        super.onPause()
        coroutineScope.cancel()
    }
}
