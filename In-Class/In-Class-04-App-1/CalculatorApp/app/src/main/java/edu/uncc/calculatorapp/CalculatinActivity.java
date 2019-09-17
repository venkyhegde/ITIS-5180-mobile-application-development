package edu.uncc.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CalculatinActivity extends AppCompatActivity {

    int op = 0;
    double sum = 0;
    final static String RESULT_KEY = "RESULT";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculatin);
        setTitle("Calculating Activity");

        if(getIntent() != null && getIntent().getExtras() != null){
            String opp = getIntent().getExtras().getString(MainActivity.OP_KEY);

            if (opp.equalsIgnoreCase("add")){
            op = 1;
            } else{
            op = 0;
            }
        }

    }

    public void calculate(View v){
        EditText num1 = findViewById(R.id.editTextNumbe1);
        EditText num2 = findViewById(R.id.editTextNuber2);

        if(op == 1){
            sum =
                    Integer.parseInt(num1.getText().toString()) + Integer.parseInt(num2.getText().toString());
        } else if(op == 0){
            sum =
                    Math.abs(Integer.parseInt(num1.getText().toString()) - Integer.parseInt(num2.getText().toString()));
        }

        Intent intent = new Intent();
        intent.putExtra(RESULT_KEY, sum);
        setResult(RESULT_OK, intent);

        finish();
    }
}
