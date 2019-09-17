package edu.uncc.parampassapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class ParcelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcel);
        setTitle("Parcel Activity");

        if (getIntent() != null && getIntent().getExtras() != null){
            Person person =  getIntent().getExtras().getParcelable(MainActivity.PERSON_KEY);

            Toast.makeText(this, person.toString(), Toast.LENGTH_SHORT).show();

        }
    }
}
