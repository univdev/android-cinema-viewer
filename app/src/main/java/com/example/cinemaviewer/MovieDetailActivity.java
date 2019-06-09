package com.example.cinemaviewer;

import android.media.Image;
import android.media.Rating;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class MovieDetailActivity extends AppCompatActivity {

    private ImageView thumbnail;
    private TextView title;
    private TextView description;
    private RatingBar rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        int thumbnail = getIntent().getIntExtra("thumbnail", 0);
        String title = getIntent().getStringExtra("title");
        String description = getIntent().getStringExtra("description");
        float score = getIntent().getFloatExtra("score", 0f);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detail);

        this.thumbnail = (ImageView) findViewById(R.id.thumbnail);
        this.title = (TextView) findViewById(R.id.title);
        this.description = (TextView) findViewById(R.id.description);
        this.rating = (RatingBar) findViewById(R.id.rating);

        System.out.println(thumbnail);
//        this.setThumbnail(thumbnail);
        this.setTitle(title);
        this.setDescription(description);
        this.setScore(score);
    }

    public void setThumbnail(int resource) {
        this.thumbnail.setImageResource(resource);
    }

    public void setTitle(String title) {
        this.title.setText(title);
    }

    public void setDescription(String description) {
        this.description.setText(description);
    }

    public void setScore(float score) {
        this.rating.setRating(score);
    }
}
