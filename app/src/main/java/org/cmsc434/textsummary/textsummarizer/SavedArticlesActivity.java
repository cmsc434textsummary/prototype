package org.cmsc434.textsummary.textsummarizer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class SavedArticlesActivity extends AppCompatActivity {

    ArrayList<String> items =  new ArrayList<>();
    public static Menu menu;
    public static MenuItem account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend_article);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        /*   code here   */
        /* Drop down list Adapter */
        final ListView checkboxView = (ListView)findViewById(R.id.listView1);
        checkboxView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        ArrayList<String> items= new ArrayList<>(Arrays.asList("Article1", "Article2", "Article3","Article4", "Article5", "Article6","Article7"));
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.savedarticle, R.id.textview, items);
        checkboxView.setAdapter(adapter);
//        checkboxView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        // checkboxView.setOnItemClickListener(new AdapterView.On);

        /* Button Activities */

        Button selectAll = findViewById(R.id.selectAll);
        selectAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for ( int i=0; i < checkboxView.getChildCount(); i++) {
                    checkboxView.setItemChecked(i, true);
                }

            }
        });
        for (int j=0; j < adapter.getCount(); j++) {
            View v = adapter.getView(j, null, null);
            final int f = j;
            v.findViewById(R.id.removebutton).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    adapter.remove(adapter.getItem(f));
                }
            });
        }
        TextView submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SavedArticlesActivity.this, SummaryActivity.class));
            }
        });

        TextView back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SavedArticlesActivity.this, MainActivity.class));
                finish();
            }
        });


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
