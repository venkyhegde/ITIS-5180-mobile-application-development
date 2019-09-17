package edu.uncc.parampassapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        setTitle("Third Activity");


        if (getIntent() != null && getIntent().getExtras() != null){

            User user = (User) getIntent().getExtras().getSerializable(MainActivity.USER_KEY);
            Toast.makeText(this, user.toString(),
                    Toast.LENGTH_LONG).show();
        }

    }
}
