package org.cmsc434.textsummary.textsummarizer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AccountActivity extends BaseMenuActivity {

    private static EditText emailView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        emailView = findViewById(R.id.email);

        if(signedIn) {
            emailView.setText(userAccount);
        }
    }

    public void signOutOnClick(View view) {
        signedIn = false;
        userAccount = null;
        Toast.makeText(getApplicationContext(), getText(R.string.signed_out), Toast.LENGTH_LONG).show();
        finish();
    }
}
