package com.example.novelworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

    }

    public void novel1(View view) {
        Intent intent = new Intent(SecondActivity.this,Read.class);
        intent.putExtra("titleKey", getString(R.string.novel1_title));
        intent.putExtra("imageKey", R.drawable.novel1);
        intent.putExtra("descriptionKey", getString(R.string.lorem_ipsum));
        startActivity(intent);


    }
    public void novel2 (View view) {
        Intent intent = new Intent(SecondActivity.this,Read.class);
        intent.putExtra("titleKey", getString(R.string.novel2_title));
        intent.putExtra("imageKey", R.drawable.novel2);
        intent.putExtra("descriptionKey", getString(R.string.novel2_chapter));
        startActivity(intent);
    }
    public void novel3 (View view) {
        Intent intent = new Intent(SecondActivity.this,Read.class);
        intent.putExtra("titleKey", getString(R.string.novel2_title));
        intent.putExtra("imageKey", R.drawable.novel3);
        intent.putExtra("descriptionKey", getString(R.string.novel2_chapter));
        startActivity(intent);
    }
    public void novel4 (View view) {
        Intent intent = new Intent(SecondActivity.this,Read.class);
        intent.putExtra("titleKey", getString(R.string.novel2_title));
        intent.putExtra("imageKey", R.drawable.novel4);
        intent.putExtra("descriptionKey", getString(R.string.novel2_chapter));
        startActivity(intent);
    }
}
