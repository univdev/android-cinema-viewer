package com.example.cinemaviewer;

import android.media.Image;
import android.media.Rating;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.cinemaviewer.schema.ReviewSchema;

import java.util.ArrayList;

public class MovieDetailActivity extends AppCompatActivity {

    private ImageView thumbnail;
    private TextView title;
    private TextView description;
    private RatingBar rating;
    private ArrayList<ReviewSchema> reviews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        int thumbnail = getIntent().getIntExtra("thumbnail", 0);
        String title = getIntent().getStringExtra("title");
        String description = getIntent().getStringExtra("description");
        float score = getIntent().getFloatExtra("score", 0f);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detail);

        this.reviews = new ArrayList<ReviewSchema>();
        this.reviews.add(new ReviewSchema("댓글1", "2019-06-09", "안녕하세요? 댓글입니다."));
        this.reviews.add(new ReviewSchema("댓글2", "2019-06-09", "안녕하세요? 댓글입니다."));
        this.reviews.add(new ReviewSchema("댓글3", "2019-06-09", "안녕하세요? 댓글입니다."));
        this.reviews.add(new ReviewSchema("댓글4", "2019-06-09", "안녕하세요? 댓글입니다."));
        this.reviews.add(new ReviewSchema("댓글5", "2019-06-09", "안녕하세요? 댓글입니다."));
        this.reviews.add(new ReviewSchema("댓글6", "2019-06-09", "안녕하세요? 댓글입니다."));
        this.reviews.add(new ReviewSchema("댓글7", "2019-06-09", "안녕하세요? 댓글입니다."));


        this.thumbnail = (ImageView) findViewById(R.id.thumbnail);
        this.title = (TextView) findViewById(R.id.title);
        this.description = (TextView) findViewById(R.id.description);
        this.rating = (RatingBar) findViewById(R.id.rating);

//        this.setThumbnail(thumbnail);
        this.setTitle(title);
        this.setDescription(description);
        this.setScore(score);

        this.setReviews();
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

    public void setReviews() {
        LinearLayout movieList = (LinearLayout) findViewById(R.id.review_list);

        for (ReviewSchema review : reviews) {
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            lp.setMargins(0, 0, 0, 16);

            View reviewTemplate = new MovieReview(this);
            ((MovieReview) reviewTemplate).setAuthor(review.author);
            ((MovieReview) reviewTemplate).setDate(review.date);
            ((MovieReview) reviewTemplate).setComment(review.comment);

            reviewTemplate.setLayoutParams(lp);

            movieList.addView(reviewTemplate);
        }
    }
}
