package com.example.cinemaviewer;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cinemaviewer.schema.ReviewSchema;

import java.util.ArrayList;

public class MovieReview extends LinearLayout {

    private TextView author;
    private TextView date;
    private TextView comment;

    public MovieReview(Context context) {
        super(context);
        init();
    }

    public MovieReview(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        getAttrs(attrs);
    }

    public void getAttrs(AttributeSet attrs) {
        TypedArray arr = getContext().obtainStyledAttributes(attrs, R.styleable.movie_selector);
        init();
        setTypedArray(arr);
    }

    private void init() {
        String inflater = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(inflater);
        View view = layoutInflater.inflate(R.layout.movie_review, this, false);

        addView(view);

        author = (TextView) findViewById(R.id.author);
        date = (TextView) findViewById(R.id.date);
        comment = (TextView) findViewById(R.id.comment);
    }

    private void setTypedArray(TypedArray attrs) {
        String author = attrs.getString(R.styleable.movie_review_author);
        String date = attrs.getString(R.styleable.movie_review_date);
        String comment = attrs.getString(R.styleable.movie_review_comment);

        this.setAuthor(author);
        this.setDate(date);
        this.setComment(comment);
    }

    public void setAuthor(String author) {
        this.author.setText(author);
    }

    public void setDate(String date) {
        this.date.setText(date);
    }

    public void setComment(String comment) {
        this.comment.setText(comment);
    }
}
