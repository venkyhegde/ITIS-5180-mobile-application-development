package edu.uncc.calculatorapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    final static String OP_KEY = "OPRATION";
    static int REQ_CODE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Main Activity");
    }

    public void add(View v){
        Intent intent = new Intent(MainActivity.this, CalculatinActivity.class);
        intent.putExtra(OP_KEY, "add");
        startActivityForResult(intent, REQ_CODE);
    }

    public void subtract(View v){
        Intent intent = new Intent(MainActivity.this, CalculatinActivity.class);
        intent.putExtra(OP_KEY, "sub");
        startActivityForResult(intent, REQ_CODE);
    }
    /**
     * Dispatch incoming result to the correct fragment.
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_CODE){
            if (resultCode == RESULT_OK){
                double result = data.getExtras().getDouble(CalculatinActivity.RESULT_KEY);

                TextView tv = findViewById(R.id.textViewAns);
                tv.setText(""+result);
            }
        }

    }
}
