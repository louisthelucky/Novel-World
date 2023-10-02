package com.example.novelworld;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Comment extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.novelworld.extra.REPLY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.commenttab);

        Intent intent = getIntent();
        String message = intent.getStringExtra(Read.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.allcomments);
        textView.setText(message);

    }

}
