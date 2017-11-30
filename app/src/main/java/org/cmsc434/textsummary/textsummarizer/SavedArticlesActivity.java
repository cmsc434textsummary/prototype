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

public class SavedArticlesActivity extends BaseMenuActivity {

    ArrayList<String> items =  new ArrayList<>();

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
        ArrayList<String> items= new ArrayList<>(Arrays.asList("10 Step To Successful Study", "How to Build Muscle", "How To Make Money","How to Diet", "Earn Money From Internet", "Guide to Bake Cookies","10 Rules to Survive in CS"));
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

//<Button
//        android:id="@+id/removebutton"
//        android:layout_width="match_parent"
//        android:layout_height="match_parent"
//        android:text="Remove"
//                />
//
//
//
//        for (int j=0; j < adapter.getCount(); j++) {
//            View v = adapter.getView(j, null, null);
//            final int f = j;
//            v.findViewById(R.id.removebutton).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    adapter.remove(adapter.getItem(f));
//                }
//            });
//        }



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

}
