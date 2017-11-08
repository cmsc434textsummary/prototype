package org.cmsc434.textsummary.textsummarizer;

/**
 * Created by steve on 11/8/2017.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Tab2 extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab2, container, false);
        Button submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent submitIntent = new Intent(this, SummaryActivity.class);
                startActivity(new Intent(Tab2.this, SummaryActivity.class));
            }
        });

        Button back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent backIntent = new Intent(this, MainActivity.class);
                startActivity(new Intent(Tab2.this, MainActivity.class));


            }
        });
        return view;
    }

}