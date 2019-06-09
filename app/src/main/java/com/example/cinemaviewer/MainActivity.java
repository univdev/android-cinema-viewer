package com.example.cinemaviewer;

import android.content.Context;
import android.content.Intent;
import android.graphics.Movie;
import android.media.Rating;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.cinemaviewer.schema.MovieSchema;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<MovieSchema> movies = new ArrayList();
        movies.add(new MovieSchema(R.drawable.badman,"악인전", "신파극이지만 재밌습니다.", 4.5f));
        movies.add(new MovieSchema("걸캅스", "페미니즘 영화입니다. 발로 걷어차주세요."));
        movies.add(new MovieSchema("영혼보내기", "예매 후 취소하는게 영혼보내기 ㅇㅈㄹ ㅋㅋㅋㅋ"));

        this.setMovies(movies);
    }

    private void setMovies(ArrayList<MovieSchema> schemas) {
        LinearLayout list = (LinearLayout) findViewById(R.id.movie_list);

        for (MovieSchema schema : schemas) {
            int thumbnail = schema.thumbnail;
            String title = schema.title;
            String description = schema.description;
            float score = schema.score;

            View view = new MovieSelector(this);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            lp.setMargins(0, 0, 0, 24);
            ((MovieSelector) view).setThumbnail(thumbnail);
            ((MovieSelector) view).setTitle(title);
            ((MovieSelector) view).setDescription(description);
            ((MovieSelector) view).setScore(score);
            view.setLayoutParams(lp);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewDetail(v);
                }
            });

            list.addView(view);
        }
    }

    public void viewDetail(View view) {
        Intent intent = new Intent(this, MovieDetailActivity.class);
        ImageView thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
        TextView title = (TextView) view.findViewById(R.id.label);
        TextView description = (TextView) view.findViewById(R.id.description);
        RatingBar rating = (RatingBar) view.findViewById(R.id.score);

        intent.putExtra("thumbnail", thumbnail.getId());
        intent.putExtra("title", title.getText().toString());
        intent.putExtra("description", description.getText().toString());
        intent.putExtra("score", rating.getRating());

        startActivity(intent);
    }
}
