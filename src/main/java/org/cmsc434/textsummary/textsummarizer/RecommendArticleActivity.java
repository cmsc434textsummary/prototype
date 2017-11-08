package org.cmsc434.textsummary.textsummarizer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import java.util.ArrayList;
import android.widget.ListView;

public class RecommendArticleActivity extends AppCompatActivity {

    ArrayList<String> items =  new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend_article);
        /*   code here   */
        /* Drop down list Adapter */
        final ListView checkboxView = (ListView)findViewById(R.id.listView1);
        checkboxView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        String[] items={"Article1", "Article2", "Article3","Article4", "Article5", "Article6","Article7"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.checkbox, R.id.textview, items);
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
        Button submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent submitIntent = new Intent(this, SummaryActivity.class);
                startActivity(new Intent(RecommendArticleActivity.this, SummaryActivity.class));
            }
        });

        Button back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent backIntent = new Intent(this, MainActivity.class);
                startActivity(new Intent(RecommendArticleActivity.this, MainActivity.class));


            }
        });
    }

}
