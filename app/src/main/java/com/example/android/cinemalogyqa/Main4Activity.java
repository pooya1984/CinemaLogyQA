package com.example.android.cinemalogyqa;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

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


    public void OpenForthQ (View view){
        RadioButton answer1 = (RadioButton) findViewById(R.id.corect_answer_three);
        boolean right1 = answer1.isChecked();
        if (right1) {
            quantity = quantity + 1;}

        Intent myIntent = new Intent(Main4Activity.this, Main5Activity.class);
        myIntent.putExtra("score", quantity);
        myIntent.putExtra("message_key",message);
        startActivity(myIntent);

    }
}
