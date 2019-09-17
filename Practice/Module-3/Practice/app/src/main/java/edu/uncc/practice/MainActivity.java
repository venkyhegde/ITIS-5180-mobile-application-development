package edu.uncc.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        Log.d("Demo","On start!");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.d("Demo","On stop!");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("Demo","On Destroy!");
        super.onDestroy();
    }

    /**
     * Dispatch onPause() to fragments.
     */
    @Override
    protected void onPause() {
        Log.d("Demo","On pause!");
        super.onPause();
    }


    @Override
    protected void onResume() {
        Log.d("Demo","On resume!");
        super.onResume();
    }
}
