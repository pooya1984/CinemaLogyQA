package com.example.android.cinemalogyqa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Main10Activity extends AppCompatActivity {

    int quantity;
    String message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);

        Intent mIntent = getIntent();
        quantity = mIntent.getIntExtra("score", 0);
        message = mIntent.getStringExtra("message_key");

    }

    //result in end activity //

    public void ShowResult (View view){


        if (quantity>6){
            ImageView cinema = (ImageView) findViewById(R.id.cinemaroll);
            cinema.setImageResource(R.drawable.good);
            String messages="Congratulations "+ message +"\n You are a really cinema fan"
                    +"\n you answered " + quantity + " of eight questions correct";
            displayMessage(messages);
        }else if (quantity>4) {
            ImageView cinema = (ImageView) findViewById(R.id.cinemaroll);
            cinema.setImageResource(R.drawable.theater_icon);
            String messages = "Good enough "+ message +"\nYou are a cinema fan but you must see more movies"
                    +"\n you answered " + quantity + " of 8 questions correct" ;
            displayMessage(messages);
        }else {
            ImageView cinema = (ImageView) findViewById(R.id.cinemaroll);
            cinema.setImageResource(R.drawable.badbad);
            String messages = "Ok "+message+"\n maybey you must more see films and then try again :)"
                    +"\n you answered " + quantity + " of eight questions correct" ;
            displayMessage(messages);
        }
    }

    private void displayMessage(String messages) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(messages);
    }
}
