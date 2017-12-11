package org.cmsc434.textsummary.textsummarizer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import java.util.ArrayList;
import android.widget.ListView;
import android.widget.TextView;

public class RecommendArticleActivity extends BaseMenuActivity {

    ArrayList<String> items =  new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend_article);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        setTitle("Recommended Articles");


        /*   code here   */
        /* Drop down list Adapter */
        final ListView checkboxView = (ListView)findViewById(R.id.listView1);
        checkboxView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        String[] items={getString(R.string.sample1_title),"How to Make Pasta","10 Step To Successful Outsourcing", getString(R.string.sample2_title),  getString(R.string.sample3_title),"6 Instant Confidence Boosters", "Tips To Make Money Online","No Cellphones By Law", "Money With Facebook Ads", "Guide to Making Money Online","24 Rules Creating Successful Websites"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.checkbox, R.id.textview, items);
        checkboxView.setAdapter(adapter);
//        checkboxView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

       // checkboxView.setOnItemClickListener(new AdapterView.On);

        /* Button Activities */

//        Button selectAll = findViewById(R.id.selectAll);
//        selectAll.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                for ( int i=0; i < checkboxView.getChildCount(); i++) {
//                    checkboxView.setItemChecked(i, true);
//                }
//
//            }
//        });

        checkboxView.setAdapter(adapter);
        checkboxView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(RecommendArticleActivity.this, SummaryActivity.class);
                startActivity(intent);
            }
        });

        checkboxView.requestFocus();


    }

}
