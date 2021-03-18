package com.example.fragmentsample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class DemoActivity extends AppCompatActivity implements ListFragment.Listener {

    public static Intent getIntent(@NonNull final Context context) {
        return new Intent(context, DemoActivity.class);
    }

    private int detailFrameLayoutId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        if (getResources().getBoolean(R.bool.is_pad)) {
            detailFrameLayoutId = R.id.demoDetailContainer;
        } else {
            detailFrameLayoutId = R.id.demoMainContainer;
        }

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.demoMainContainer, ListFragment.newInstance(), ListFragment.TAG)
                    .addToBackStack(null)
                    .commit();
        }
    }

    @Override
    public void showDetailFragment(@NonNull final String name) {
        if (getSupportFragmentManager().findFragmentByTag(DetailFragment.TAG) != null) {
            // Если на экране уже есть фрагмент с деталями, то надо его убрать перед показом нового
            getSupportFragmentManager().popBackStack();
        }

        getSupportFragmentManager()
                .beginTransaction()
                .replace(detailFrameLayoutId, DetailFragment.newInstance(name), DetailFragment.TAG)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
            finish();
        } else {
            super.onBackPressed();
        }
    }
}
