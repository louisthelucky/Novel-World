package com.example.novelworld;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Read extends AppCompatActivity {

    public TextView title;
    public ImageView novelpic;
    public TextView chap;

    public EditText comment;

    public static final String EXTRA_MESSAGE = "com.example.android.novelworld.extra.MESSAGE";

    public static final int TEXT_REQUEST = 1;

    private static final String LOG_TAG = Read.class.getSimpleName();

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

    @Override
    protected void onStop() {
        super.onStop();
        comment = findViewById(R.id.commentText);
        comment.setText("");
        Log.d(LOG_TAG, "onStop");
    }
    @Override
    public void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }


    public void displayToast(String mes) {
        Toast.makeText(getApplicationContext(), mes, Toast.LENGTH_SHORT).show();
    }
    public void heartClk (View view) {
        displayToast("You heart the Novel: " + title.getText());
    }
    public void comClk(View view) {
        comment = findViewById(R.id.commentText);

        String message = comment.getText().toString();

        // Check if the message is not empty or null
        if (!message.isEmpty()) {
            Intent intent = new Intent(this, Comment.class);
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivityForResult(intent, TEXT_REQUEST);
        } else {
            // Display a toast message if there is no comment
            Toast.makeText(this, "Please enter a comment", Toast.LENGTH_SHORT).show();
        }
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
