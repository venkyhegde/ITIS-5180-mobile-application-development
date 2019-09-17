package edu.uncc.parampassapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setTitle("Second Activity");

        // getting an intent
        if (getIntent() != null && getIntent().getExtras() != null){
            Toast.makeText(this,
                    "Name: "+getIntent().getExtras().getString(MainActivity.NAME_KEY)+" Age:"+getIntent().getExtras().getDouble(MainActivity.AGE_KEY), Toast.LENGTH_SHORT).show();
        }
    }
}
