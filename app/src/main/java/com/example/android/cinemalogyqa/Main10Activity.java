package com.example.android.cinemalogyqa;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
                    +"\n you answered " + quantity + " of 8 questions correct" ;
            displayMessage(messages);
        }
    }

    private void displayMessage(String messages) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(messages);
    }
    //menubar links
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        switch (item.getItemId()) {
            case R.id.About_id:
                startActivity(new Intent(this, About.class));
                return true;
            case R.id.thema_id:
                Toast.makeText(getApplicationContext(), "No thema yet", Toast.LENGTH_LONG).show();
                return true;
            case R.id.share_id:
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");

                String messages = message;
                if (quantity > 6) {
                    ImageView cinema = (ImageView) findViewById(R.id.cinemaroll);
                    cinema.setImageResource(R.drawable.good);
                    messages = "Congratulations " + message + "\n You are a really cinema fan"
                            + "\n you answered " + quantity + " of eight questions correct";
                    displayMessage(messages);
                } else if (quantity > 4) {
                    ImageView cinema = (ImageView) findViewById(R.id.cinemaroll);
                    cinema.setImageResource(R.drawable.theater_icon);
                    messages = "Good enough " + message + "\nYou are a cinema fan but you must see more movies"
                            + "\n you answered " + quantity + " of 8 questions correct";
                    displayMessage(messages);
                } else {
                    ImageView cinema = (ImageView) findViewById(R.id.cinemaroll);
                    cinema.setImageResource(R.drawable.badbad);
                    messages = "Ok " + message + "\n maybey you must more see films and then try again :)"
                            + "\n you answered " + quantity + " of eight questions correct";
                    displayMessage(messages);
                }
                String shareBody = messages;
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
            default:
        }
        return super.onOptionsItemSelected(item);}}