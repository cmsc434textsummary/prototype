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

    public String
            url,
            saved;



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
        int urlId, favId, imageId, authorId, sourceId, textId;


        if(data != null) {
            saved = data.getString("saved");
        }

        if(saved != null && !saved.isEmpty()) {
            if(saved.equals(getString(R.string.sample1_title))) {
                urlId = R.string.sample1_url;
                favId = R.string.sample1_favicon_path;
                imageId = R.string.sample1_image_path;
                authorId = R.string.sample1_author;
                sourceId = R.string.sample1_source;
                textId = R.string.sample1_text;
            } else if (saved.equals(getString(R.string.sample2_title))) {
                urlId = R.string.sample2_url;
                favId = R.string.sample2_favicon_path;
                imageId = R.string.sample2_image_path;
                authorId = R.string.sample2_author;
                sourceId = R.string.sample2_source;
                textId = R.string.sample2_text;
            } else {
                urlId = R.string.sample3_url;
                favId = R.string.sample3_favicon_path;
                imageId = R.string.sample3_image_path;
                authorId = R.string.sample3_author;
                sourceId = R.string.sample3_source;
                textId = R.string.sample3_text;
            }

            url = getText(urlId).toString();

        /*  Sample display of summary */
            int imageResource = getResources().getIdentifier(getText(favId).toString(), null, getPackageName());
            Bitmap favicon = BitmapFactory.decodeResource(getResources(), imageResource);
            siteLogoImgView.setImageBitmap(favicon);
            imageResource = getResources().getIdentifier(getText(imageId).toString(), null, getPackageName());
            Bitmap image = BitmapFactory.decodeResource(getResources(), imageResource);
            articleImgView.setImageBitmap(image);

            displayAuthorView.setText(authorId);
            displayTitleView.setText(saved);
            displaySiteNameView.setText(sourceId);
            displayTextView.setText(textId);

        } else {
            url = getText(R.string.sample1_url).toString();

            int imageResource = getResources().getIdentifier(getText(R.string.sample1_favicon_path).toString(), null, getPackageName());
            Bitmap favicon = BitmapFactory.decodeResource(getResources(), imageResource);

            siteLogoImgView.setImageBitmap(favicon);
            imageResource = getResources().getIdentifier(getText(R.string.sample1_image_path).toString(), null, getPackageName());
            Bitmap image = BitmapFactory.decodeResource(getResources(),imageResource);

            articleImgView.setImageBitmap(image);

            displayAuthorView.setText(R.string.sample1_author);
            displayTitleView.setText(R.string.sample1_title);
            displaySiteNameView.setText(R.string.sample1_source);
            displayTextView.setText(R.string.sample1_text);
        }



        /* TODO needed for actual implementation */
//        if(!URLUtil.isValidUrl(url)) {
//            Toast.makeText(getApplicationContext(), getText(R.string.invalid_url), Toast.LENGTH_LONG).show();
//            setResult(RESULT_CANCELED);
//            finish();
//        }



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
        i.putExtra("url", url);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, SummaryConfigActivity.class);
        i.putExtra("url", url);
        super.onBackPressed();

    }

    public void fullOnClick(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        if(getPackageManager().resolveActivity(i, 0) != null) {
            startActivity(i);
        }
    }

}
