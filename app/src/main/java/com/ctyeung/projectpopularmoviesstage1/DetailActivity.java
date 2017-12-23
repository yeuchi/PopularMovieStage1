package com.ctyeung.projectpopularmoviesstage1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.ctyeung.projectpopularmoviesstage1.utilities.JSONhelper;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.ctyeung.projectpopularmoviesstage1.utilities.MovieHelper;

import org.json.JSONObject;

public class DetailActivity extends AppCompatActivity {


    private TextView tvTitle;
    private ImageView ivPoster;
    private TextView tvPlot;
    private TextView tv_rating;
    private TextView tv_release_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvTitle = (TextView)findViewById(R.id.tv_original_title);
        ivPoster = (ImageView)findViewById(R.id.iv_poster_image);
        tvPlot = (TextView)findViewById(R.id.tv_plot);
        tv_rating = (TextView)findViewById(R.id.tv_rating);
        tv_release_date = (TextView)findViewById(R.id.tv_release_date);

        initializeElements();
    }

    protected void initializeElements()
    {
        String str = this.getIntent().getStringExtra(Intent.EXTRA_TEXT);
        JSONObject json = JSONhelper.parseJson(str);

        String voteAverage = JSONhelper.parseValueByKey(json, MovieHelper.KEY_VOTE_AVERAGE);
        tv_rating.setText("Vote Average: " + voteAverage);

        String date = JSONhelper.parseValueByKey(json, MovieHelper.KEY_RELEASE_DATE);
        tv_release_date.setText("Date: " + date);

        String plot = JSONhelper.parseValueByKey(json, MovieHelper.KEY_PLOT);
        tvPlot.setText("Plot: " + plot);

        String title = JSONhelper.parseValueByKey(json, MovieHelper.KEY_ORIGINAL_TITLE);
        tvTitle.setText("Title: " + title);

        Context context = getApplicationContext();

        String url = MovieHelper.BASE_POSTER_URL +
                    MovieHelper.getSizeByIndex(MovieHelper.INDEX_DETAIL) +
                    JSONhelper.parseValueByKey(json, MovieHelper.KEY_POSTER_PATH);

        Picasso.with(context)
                //.load("http://i.imgur.com/DvpvklR.png")
                .load(url)
                .placeholder(R.drawable.placeholder)   // optional
                .error(R.drawable.placeholder)      // optional
                .into(ivPoster, new Callback() {
                    @Override
                    public void onSuccess() {
                        //Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError() {
                        //Toast.makeText(getApplicationContext(), "failed", Toast.LENGTH_SHORT).show();
                    }
                });

    }
}
