package com.example.novelworld;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Read extends AppCompatActivity {

    public TextView title;
    public ImageView novelpic;
    public TextView chap;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read);

        String title1 = getIntent().getStringExtra("titleKey");
        int imageResource = getIntent().getIntExtra("imageKey", 0);
        String description = getIntent().getStringExtra("descriptionKey");

        title = findViewById(R.id.novelTitle);
        novelpic = findViewById(R.id.novelPic);
        chap = findViewById(R.id.novelChap);

        title.setText(title1);
        novelpic.setImageResource(imageResource);
        chap.setText(description);


    }


    public void displayToast(String mes) {
        Toast.makeText(getApplicationContext(), mes, Toast.LENGTH_SHORT).show();
    }
    public void heartClk (View view) {
        displayToast("You been heart the Novel");
    }
    public void comClk (View view) {
        displayToast("comment");
        Intent intent = new Intent(Read.this, Comment.class);
        startActivity(intent);
    }
    public void shareClk (View view) {
        String txt = getIntent().getStringExtra("titleKey");
        String mimeType = "text/plain";

        ShareCompat.IntentBuilder.from(this)
                .setType(mimeType)
                .setChooserTitle(R.string.share_this_text_with)
                .setText(txt)
                .startChooser();

    }
    public void webClk (View view) {
        String url = "https://www.lightnovelcave.com/home_16091837?fbclid=IwAR05FaC0cw2zrRbsBZgwCo0q07RH3vWd3ZkVeZzSinvts9z91bNDeIiSWIc";

        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
    }
}
