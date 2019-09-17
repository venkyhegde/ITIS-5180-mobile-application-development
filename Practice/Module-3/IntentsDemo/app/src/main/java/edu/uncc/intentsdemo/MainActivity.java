package edu.uncc.intentsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Main Activity");

        findViewById(R.id.buttonGo2Second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go2Second = new Intent(getBaseContext(), SecondActivity.class);
                startActivity(go2Second);
            }
        });


        // implicit intent
        findViewById(R.id.buttonImplicitIn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent impIntent = new Intent("edu.uncc.intentsdemo.intent.action.VIEW");
                impIntent.addCategory(Intent.CATEGORY_DEFAULT);
                startActivity(impIntent);
            }
        });
    }
}
