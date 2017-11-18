package org.cmsc434.textsummary.textsummarizer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static EditText urlEditText;
    public static Menu menu;
    public static MenuItem account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        urlEditText = findViewById(R.id.textView);

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

    public void myArticles(View view) {
        Intent intent = new Intent(this, SavedArticlesActivity.class);
        startActivity(intent);
    }

    public void recommended(View view) {
        Intent intent = new Intent(this, RecommendArticleActivity.class);
        startActivity(intent);
    }

    public void sampleOnClick(View view) {
        Intent intent = new Intent(this, SummaryActivity.class);
        startActivity(intent);
    }

    /* Options menu inflate and onClicks */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        for (int j = 0; j < menu.size(); j++) {
            MenuItem item = menu.getItem(j);
            item.setShowAsActionFlags(MenuItem.SHOW_AS_ACTION_ALWAYS);
        }
        getMenuInflater().inflate(R.menu.account_menu_btn, menu);
        this.menu = menu;
        account = menu.findItem(R.id.account_btn);
        return super.onCreateOptionsMenu(menu);

    }

    public void accountOnClick(MenuItem item) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void homeOnClick(MenuItem item) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
