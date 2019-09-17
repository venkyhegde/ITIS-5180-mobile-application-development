package edu.uncc.parampassapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    static String NAME_KEY = "NAME";
    static String AGE_KEY = "AGE";
    static String USER_KEY = "user";
    static String PERSON_KEY = "person";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Main Activity");

        findViewById(R.id.buttonOne).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // creating new intent
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                // adding parameter
                intent.putExtra(NAME_KEY, "Alice");
                intent.putExtra(AGE_KEY, 23.5);

                startActivity(intent);
            }
        });

        findViewById(R.id.buttonTwo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // creating new intent
                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);

                // creating user object
                User user = new User("Bob Vance", 54.2);
                intent.putExtra(USER_KEY, user);
                startActivity(intent);
            }
        });

        findViewById(R.id.buttonThree).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // create an intent
                Intent intent = new Intent(MainActivity.this, ParcelActivity.class);
                intent.putExtra(PERSON_KEY, new Person("Martin", 27.5, "Charlotte"));

                startActivity(intent);
            }
        });

        findViewById(R.id.buttonFour).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uncc.edu"));
                startActivity(intent);
            }
        });
    }
}
