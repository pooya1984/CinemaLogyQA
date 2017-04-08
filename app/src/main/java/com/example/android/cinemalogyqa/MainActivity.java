package com.example.android.cinemalogyqa;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.edit_text);

        Button openQ = (Button) findViewById(R.id.open_first_q);


        openQ.setOnClickListener(new View.OnClickListener()
        {
            // The code in this method will be called when the numbers view is clicked on.
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, Main2Activity.class);
                String message = editText.getText().toString();
                myIntent.putExtra("message_key",message);
                startActivity(myIntent);
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        switch (item.getItemId()){
            case R.id.About_id:
                startActivity(new Intent(this, About.class));
                return true;
            case R.id.thema_id:
                Toast.makeText(getApplicationContext(),"No thema yet",Toast.LENGTH_LONG).show();
                return true;
            case R.id.share_id:
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Please download cinemalogy quizz app";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
            default:
        }
        return super.onOptionsItemSelected(item);}
}

