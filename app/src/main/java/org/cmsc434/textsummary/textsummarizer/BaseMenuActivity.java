package org.cmsc434.textsummary.textsummarizer;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

/**
 * Created by juneh on 11/18/2017.
 */

public class BaseMenuActivity extends AppCompatActivity {

    public static Menu menu;
    public static MenuItem account;
    public static boolean signedIn = false;
    public static String userAccount;

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
        adaptSignInState();
        return super.onCreateOptionsMenu(menu);

    }

    public void accountOnClick(MenuItem item) {
        if(signedIn) {
            Intent intent = new Intent(this, AccountActivity.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }

    }

    public void homeOnClick(MenuItem item) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void adaptSignInState() {
        if(signedIn) {
            menu.findItem(R.id.account_btn).setIcon(R.drawable.signin_icon);
        } else {
            menu.findItem(R.id.account_btn).setIcon(R.drawable.usericon);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        invalidateOptionsMenu();
    }
}
