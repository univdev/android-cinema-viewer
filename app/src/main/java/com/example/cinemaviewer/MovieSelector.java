package com.example.cinemaviewer;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import java.lang.ref.Reference;

public class MovieSelector extends LinearLayout {

    private Context context;
    private ImageView thumbnail;
    private TextView title;
    private TextView description;
    private RatingBar rating;
    private TextView ratingText;

    public MovieSelector(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public MovieSelector(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
        getAttrs(attrs);
    }

    public void getAttrs(AttributeSet attrs) {
        TypedArray arr = getContext().obtainStyledAttributes(attrs, R.styleable.movie_selector);
        setTypedArray(arr);
    }

    public void init() {
        String inflater = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(inflater);
        View view = layoutInflater.inflate(R.layout.movie_selector, this, false);

        addView(view);

        thumbnail = (ImageView) findViewById(R.id.thumbnail);
        title = (TextView) findViewById(R.id.label);
        description = (TextView) findViewById(R.id.description);
        rating = (RatingBar) findViewById(R.id.score);
        ratingText = (TextView) findViewById(R.id.score_text);
    }

    private void setTypedArray(TypedArray arr) {
        int thumbnail = arr.getResourceId(R.styleable.movie_selector_image, R.drawable.badman);
        this.setThumbnail(thumbnail);

        String title = arr.getString(R.styleable.movie_selector_title);
        this.setTitle(title);

        String description = arr.getString(R.styleable.movie_selector_description);
        this.setDescription(description);

        float score = arr.getFloat(R.styleable.movie_selector_score, 5);
        this.setScore(score);
    }

    private String getScoreFormat(float score) {
        return String.format("%.1f / %d", score, 5);
    }

    public void setTitle(String title) {
        this.title.setText(title);
    }

    public void setDescription(String description) {
        this.description.setText(description);
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail.setTag(thumbnail);
        this.thumbnail.setImageResource(thumbnail);
    }

    public void setScore(float score) {
        this.rating.setRating(score);
        this.ratingText.setText(getScoreFormat(score));
    }
}
