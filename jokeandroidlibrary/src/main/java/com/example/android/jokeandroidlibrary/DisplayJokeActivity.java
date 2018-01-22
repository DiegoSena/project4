package com.example.android.jokeandroidlibrary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DisplayJokeActivity extends AppCompatActivity {

    public static final String INTENT_EXTRA = "INTENT_EXTRA_JOKE";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_joke);

        String joke = getIntent().getStringExtra(INTENT_EXTRA);
        TextView textView = findViewById(R.id.joke_textview);
        textView.setText(joke);
    }


}
