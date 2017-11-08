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
public class SummaryConfigActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";

    private static EditText urlEditText;
    private static EditText lineNumEditText;
    private static CheckBox saveCheckBox;

    public static Menu menu;
    public static MenuItem account;

    private static String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_config);
        urlEditText = findViewById(R.id.url_edittext);
        lineNumEditText = findViewById(R.id.linenum_edittext);
        saveCheckBox = findViewById(R.id.save_checkbox);


        Intent received = getIntent();
        if (received != null){
            Bundle data = received.getExtras();
            url = (String) data.get("articleURL");
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
        startActivity(i);
    }

    public void accountOnClick(MenuItem item) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

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


}
