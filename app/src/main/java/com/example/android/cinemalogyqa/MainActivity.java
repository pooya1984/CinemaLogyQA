package com.example.android.cinemalogyqa;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
}
