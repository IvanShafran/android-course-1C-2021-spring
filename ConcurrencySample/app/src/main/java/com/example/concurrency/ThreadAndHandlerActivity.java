package com.example.concurrency;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ThreadAndHandlerActivity extends AppCompatActivity implements Handler.Callback {

    public static Intent getIntent(@NonNull final Context context) {
        return new Intent(context, ThreadAndHandlerActivity.class);
    }

    private static final int POST_ANSWER_WHAT = 1;

    private Handler mainHandler;
    private ProgressBar progressBar;
    private TextView textView;
    private Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample);

        mainHandler = new Handler(Looper.getMainLooper(), this);
        progressBar = findViewById(R.id.progressBar);
        textView = findViewById(R.id.textView);
    }

    @Override
    protected void onResume() {
        super.onResume();

        progressBar.setVisibility(View.VISIBLE);
        thread = new Thread() {

            @Override
            public void run() {
                final int value = TheMostImportantQuestionSolver.solve(5);

                if (isInterrupted()) {
                    return;
                }
                Message message = new Message();
                message.what = POST_ANSWER_WHAT;
                message.arg1 = value;
                mainHandler.sendMessage(message);
            }
        };
        thread.start();
        mainHandler.post(new Runnable() {
            @Override
            public void run() {
                // code
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        thread.interrupt();
    }

    @Override
    public boolean handleMessage(final Message msg) {
        if (msg.what == POST_ANSWER_WHAT) {
            textView.setText("Answer = " + msg.arg1);
            progressBar.setVisibility(View.INVISIBLE);
        }
        return true;
    }
}
