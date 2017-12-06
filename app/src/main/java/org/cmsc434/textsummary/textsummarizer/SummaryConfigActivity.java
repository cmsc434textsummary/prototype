package org.cmsc434.textsummary.textsummarizer;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.support.v4.view.ViewPager;
import android.support.v4.view.PagerAdapter;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
public class SummaryConfigActivity extends BaseMenuActivity {
    private final String TAG = "MainActivity";

    private static EditText urlEditText;
    private static EditText lineNumEditText;
    private static CheckBox saveCheckBox;

    private static String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_config);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);


        urlEditText = findViewById(R.id.url_edittext);
        lineNumEditText = findViewById(R.id.linenum_edittext);
        saveCheckBox = findViewById(R.id.save_checkbox);


        Intent received = getIntent();
        if (received != null){
            Bundle data = received.getExtras();
            url = (String) data.get("url");
        }

        if(url != null) {
            urlEditText.setText(url);
        }


    }


    public void backOnClick(View view) {
        finish();
    }

    public void submitOnClick(View view) {
        Intent i = new Intent(this, SummaryActivity.class);
        i.putExtra("url",urlEditText.getText());
        i.putExtra("linenum",lineNumEditText.getText());
        i.putExtra("keysearch",saveCheckBox.isChecked());
        i.putExtra("saved", getString(R.string.sample1_title));
        startActivity(i);
    }

}
