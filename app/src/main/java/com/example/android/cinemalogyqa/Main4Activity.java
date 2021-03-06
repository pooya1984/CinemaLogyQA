package com.example.android.cinemalogyqa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {

    int quantity;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Intent mIntent = getIntent();
        quantity = mIntent.getIntExtra("score", 0);
        message = mIntent.getStringExtra("message_key");
    }

    public void OpenForthQ(View view) {
        CheckBox chk2 = (CheckBox) findViewById(R.id.digango_answer);
        CheckBox chk3 = (CheckBox) findViewById(R.id.kill_bill);
        CheckBox chk1 = (CheckBox) findViewById(R.id.answer_three);

        if (chk2.isChecked() && chk3.isChecked()) {
            // Award Point only if incorrect CheckBoxes are unchecked
            if (!chk1.isChecked()) {
                quantity = quantity + 1;
            }
        }

        Intent myIntent = new Intent(Main4Activity.this, Main5Activity.class);
        myIntent.putExtra("score", quantity);
        myIntent.putExtra("message_key", message);
        startActivity(myIntent);
    }

    //menubar links
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.About_id:
                startActivity(new Intent(this, About.class));
                return true;
            case R.id.thema_id:
                Toast.makeText(getApplicationContext(), "No thema yet", Toast.LENGTH_LONG).show();
                return true;
            default:
        }
        return super.onOptionsItemSelected(item);
    }
}