package org.cmsc434.textsummary.textsummarizer;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URI;
import java.net.URL;

public class SummaryActivity extends BaseMenuActivity {

    public static ImageView
            siteLogoImgView,
            articleImgView;
    public static TextView
            displayTextView,
            displayTitleView,
            displayAuthorView,
            displaySiteNameView;
    public static TextView
            saveTextView;
    public static boolean isSaved = false;

    public String url;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);



        displaySiteNameView = (TextView) findViewById(R.id.displaySiteNameView);
        displayTitleView = (TextView) findViewById(R.id.displayTitleView);
        displayAuthorView = (TextView) findViewById(R.id.displayAuthorNameView);
        displayTextView = (TextView) findViewById(R.id.displayTextView);
        siteLogoImgView = (ImageView) findViewById(R.id.displaySiteImageView);
        articleImgView = (ImageView) findViewById(R.id.displayArticleImageView);
        saveTextView = (TextView) findViewById(R.id.savetextView);

        Bundle data = getIntent().getExtras();

//        if(data != null) {
//            url = ((SpannableString) data.get("url")).toString();
//        } else {
//
//        }
        url = getText(R.string.sample_url).toString();

        /* TODO needed for actual implementation */
//        if(!URLUtil.isValidUrl(url)) {
//            Toast.makeText(getApplicationContext(), getText(R.string.invalid_url), Toast.LENGTH_LONG).show();
//            setResult(RESULT_CANCELED);
//            finish();
//        }


        /*  Sample display of summary */
        int imageResource = getResources().getIdentifier(getText(R.string.sample_favicon_path).toString(), null, getPackageName());
        Bitmap favicon = BitmapFactory.decodeResource(getResources(), R.drawable.wp_favicon);
        siteLogoImgView.setImageBitmap(favicon);
        imageResource = getResources().getIdentifier(getText(R.string.sample_image_path).toString(), null, getPackageName());
        Bitmap image = BitmapFactory.decodeResource(getResources(), R.drawable.wp_image);
        articleImgView.setImageBitmap(image);

        displayAuthorView.setText(R.string.sample_author);
        displayTitleView.setText(R.string.sample_title);
        displaySiteNameView.setText(R.string.sample_source);
        displayTextView.setText(R.string.sample_text);


    }


    public void saveOnClick(View view) {
        if(isSaved) {
            Toast.makeText(getApplicationContext(), getText(R.string.is_unsaved), Toast.LENGTH_LONG).show();
            saveTextView.setText("Save");
            isSaved = false;
        } else {
            Toast.makeText(getApplicationContext(), getText(R.string.is_saved), Toast.LENGTH_LONG).show();
            saveTextView.setText("Unsave");
            isSaved = true;
        }
    }

    public void backOnClick(View view) {
        /* TODO save url, article text package result intent */

        //setResult(RESULT_OK);
        //finish();

        //repackaged this as an intent now that workflow places summary page before config page
        Intent i = new Intent(this, SummaryConfigActivity.class);
        i.putExtra("articleUrl", url);
        startActivity(i);
    }

    public void fullOnClick(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        if(getPackageManager().resolveActivity(i, 0) != null) {
            startActivity(i);
        }
    }

}
