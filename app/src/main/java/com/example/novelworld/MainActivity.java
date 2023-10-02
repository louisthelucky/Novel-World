package com.example.novelworld;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a Handler with the main (UI) Looper
        Handler handler = new Handler(Looper.getMainLooper());

        // Post a delayed message to show the Toast after 0.5 seconds
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Show the Toast message
                Toast.makeText(getApplicationContext(), "Click anywhere to start!!!", Toast.LENGTH_LONG).show();
            }
        }, 800);
    }

    public void trans(View view) {
        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        startActivity(intent);
    }
}
