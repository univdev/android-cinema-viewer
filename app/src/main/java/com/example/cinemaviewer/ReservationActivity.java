package com.example.cinemaviewer;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ReservationActivity extends AppCompatActivity {
    private int count = 0;
    private TextView seatCount;
    private TextView price;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_reservation);
        init();

        seatCount = findViewById(R.id.seat_count);
        price = findViewById(R.id.price);
        submit = findViewById(R.id.submit_button);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "예약을 완료했습니다!", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }

    private void init() {
        GridLayout grid = (GridLayout) findViewById(R.id.seat_grid);
        for (int i = 0; i < 25; i += 1) {
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.setMargins(10, 10, 10, 10);

            Button seat = new Button(this);
            seat.setBackgroundColor(Color.rgb(255, 255, 255));
            seat.setTag(false);
            seat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Boolean flag = (Boolean) v.getTag();
                    if (!flag) {
                        count += 1;
                        v.setBackgroundColor(Color.rgb(133, 17, 17));
                    } else {
                        count -= 1;
                        v.setBackgroundColor(Color.rgb(255, 255, 255));
                    }
                    v.setTag(!flag);
                    setSeatCount();
                    setPrice();
                }
            });
            seat.setLayoutParams(params);

            grid.addView(seat);
        }
    }

    private void setSeatCount() {
        this.seatCount.setText(String.format("%d개", this.count));
    }

    private void setPrice() {
        int price = count * 12000;
        this.price.setText(String.format("%d원", price));
    }
}
