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

public class MainActivity extends BaseMenuActivity {

    private static EditText urlEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        urlEditText = findViewById(R.id.textView);

        Intent intent = getIntent();
        if(intent != null) {
            String sharedText = getIntent().getStringExtra(Intent.EXTRA_TEXT);
            if(sharedText != null) {
                urlEditText.setText(sharedText);
                urlEditText.setSelection(0);
            }

        }

    }


    public void createSummary(View view){
        //get text from textbox
        TextView input = findViewById(R.id.textView);
        String aURL = input.getText().toString();
        Intent intent = new Intent(this, SummaryActivity.class);
        //pass text to summary activity
        intent.putExtra("articleURL", aURL);
        // open summary activity
        startActivity(intent);
    }

    public void myArticles(View view) {
        Intent intent = new Intent(this, SavedArticlesActivity.class);
        intent.putExtra("url",urlEditText.getText());
        intent.putExtra("linenum",5);
        intent.putExtra("keysearch",false);
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

    @Override
    protected void onResume() {
        super.onResume();

        this.invalidateOptionsMenu();

        Intent intent = getIntent();
        if(intent != null) {
            String sharedText = getIntent().getStringExtra(Intent.EXTRA_TEXT);
            if(sharedText != null) {
                urlEditText.setText(sharedText);
                urlEditText.setSelection(0);
            }

        }

    }
}
