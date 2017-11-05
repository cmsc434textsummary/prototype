package org.cmsc434.textsummary.textsummarizer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void createSummary(View view){
        //get text from textbox
        TextView input = findViewById(R.id.textView);
        String aURL = input.getText().toString();
        Intent intent = new Intent(this, SummaryConfigActivity.class);
        //pass text to summary activity
        intent.putExtra("articleURL", aURL);
        // open summary activity
        startActivity(intent);
    }

    public void login(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void myArticles(View view) {
        Intent intent = new Intent(this, SavedArticlesActivity.class);
        startActivity(intent);
    }

    public void recommended(View view) {
        Intent intent = new Intent(this, RecommendArticleActivity.class);
        startActivity(intent);
    }

    public void menu(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }


}
