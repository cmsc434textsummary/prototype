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

import android.widget.TextView;
public class SummaryConfigActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";

    private TabAdapter pageAdapter;

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_config);

        /*  code here  */




            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

        pageAdapter = new TabAdapter(getSupportFragmentManager());

            viewPager = (ViewPager) findViewById(R.id.container);
            setupViewPager(viewPager);

            TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
            tabLayout.setupWithViewPager(viewPager);




        Button submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent submitIntent = new Intent(this, SummaryActivity.class);
                startActivity(new Intent(SummaryConfigActivity.this, SummaryActivity.class));
            }
        });

        Button back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent backIntent = new Intent(this, MainActivity.class);
                startActivity(new Intent(SummaryConfigActivity.this, MainActivity.class));


            }
        });
    }

        private void setupViewPager(ViewPager viewPager) {
        TabAdapter adapter = new TabAdapter(getSupportFragmentManager());
            adapter.addFragment(new Tab1(), "TAB1");
            adapter.addFragment(new Tab2(), "TAB2");
            adapter.addFragment(new Tab3(), "TAB3");
            viewPager.setAdapter(adapter);
        }

}
