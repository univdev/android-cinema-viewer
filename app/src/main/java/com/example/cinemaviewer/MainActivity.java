package com.example.cinemaviewer;

import android.content.Context;
import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

import com.cinemaviewer.schema.MovieSchema;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<MovieSchema> movies = new ArrayList();
        movies.add(new MovieSchema(R.drawable.badman,"악인전", "신파극이지만 재밌습니다."));
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

            View view = new MovieSelector(this);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            lp.setMargins(0, 0, 0, 24);
            ((MovieSelector) view).setThumbnail(thumbnail);
            ((MovieSelector) view).setTitle(title);
            ((MovieSelector) view).setDescription(description);
            view.setLayoutParams(lp);

            list.addView(view);
        }
    }
}
