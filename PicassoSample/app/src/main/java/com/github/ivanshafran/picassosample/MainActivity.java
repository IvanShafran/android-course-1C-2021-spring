package com.github.ivanshafran.picassosample;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate( Bundle savedInstanceState )
	{
		super.onCreate( savedInstanceState );
		setContentView( R.layout.activity_main );
		ImageView imageView = findViewById( R.id.imageView );

        Picasso
                .get()
                .load("https://i.pinimg.com/originals/e8/8f/30/e88f3028afe762960b7a2c11837b34d1.jpg")
                .fit()
                .centerInside()
                .into(imageView);
    }
}
