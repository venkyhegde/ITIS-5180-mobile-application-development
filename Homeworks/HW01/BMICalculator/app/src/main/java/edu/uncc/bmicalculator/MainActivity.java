package edu.uncc.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import edu.uncc.bmicalculator.utility.InputRange;

/**
 * Homework 01
 * MainActivity.java
 * Chaitanya Deshpande, Akash Atul Khiste, Venky Shantharam Hegde
 *
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        hideResult();

        // to check inches between 0-11
        final EditText editTextInches = findViewById(R.id.editTextInch);
        editTextInches.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length() > 0 && !charSequence.equals(" ") ){
                    float val =  Float.parseFloat(charSequence.toString().trim());
                    editTextInches.setFilters(new InputFilter[]{new InputRange(0,12)});
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        // end of inches check

    }

    private void hideResult() {
        TextView tv = findViewById(R.id.textViewDisplayBmi);
        tv.setVisibility(View.INVISIBLE);
        TextView tv1 = findViewById(R.id.textViewBmiStatus);
        tv1.setVisibility(View.INVISIBLE);
    }

    public void calculateBmi(View view){
        // get all inputs
        float weight = getWeight();
        float height = getHeight();
        // calculating bmi.
        float bmi = 0;
        StringBuilder bmiStatus = new StringBuilder();
        if (weight > 0 && height > 12){
            Log.d("Debug", "weight - "+weight);
            Log.d("Debug", "height - "+height);
            bmi = (weight / (height * height)) * 703;

            // setting bmi status
            if (bmi <= 18.5){
                bmiStatus.append("Underweight");
            } else if (bmi > 18.5 && bmi <= 24.9){
                bmiStatus.append("Normal weight");
            } else if (bmi >= 25 && bmi <= 29.9){
                bmiStatus.append("Overweight");
            } else {
                bmiStatus.append("Obesity");
            }

            // making results visible
            TextView tv = findViewById(R.id.textViewDisplayBmi);
            tv.setText(getString(R.string.bmi_value)+" "+bmi);
            tv.setVisibility(View.VISIBLE);
            tv = findViewById(R.id.textViewBmiStatus);
            tv.setText(getString(R.string.bmi_status)+" "+bmiStatus.toString());
            tv.setVisibility(View.VISIBLE);
        } else{
            Log.d("Debug", "weight out - "+weight);
            Log.d("Debug", "height out- "+height);
            hideResult();
        }


    }

    private float getHeight() {
        EditText feets = findViewById(R.id.editTextFeet);
        EditText inches = findViewById(R.id.editTextInch);
        float feet= 0;
        float inch = 0;
        // validate and get feet
        if(feets != null && feets.getText().toString().trim().length() > 0){
            feet = Float.parseFloat(feets.getText().toString().trim());
            if (feet <= 0 ){
                hideResult();
                Toast.makeText(getApplicationContext(),"Invalid Inputs", Toast.LENGTH_SHORT).show();
                feets.setError("Invalid Input");
            }
        } else {
            hideResult();
            Toast.makeText(getApplicationContext(),"Invalid Inputs", Toast.LENGTH_SHORT).show();
            feets.setError("Invalid Input");
        }

        // validate and get inches

        if(inches != null && inches.getText().toString().trim().length() > 0){
            inch = Float.parseFloat(inches.getText().toString().trim());
            if (inch < 0 ){
                hideResult();
                Toast.makeText(getApplicationContext(),"Invalid Inputs", Toast.LENGTH_SHORT).show();
                inches.setError("Invalid Input");

            }
        } else {
            Toast.makeText(getApplicationContext(),"Invalid Inputs", Toast.LENGTH_SHORT).show();
            inches.setError("Invalid Input");
            hideResult();
        }

        // return height in inches

        return (feet * 12) + inch;

    }

    private float getWeight() {
        EditText editText = findViewById(R.id.editTextWeight);
        float weigth = 0;
        if(editText != null && editText.getText().toString().trim().length() > 0){
            weigth = Float.parseFloat(editText.getText().toString().trim());
            if (weigth <= 0 ){
                hideResult();
                Toast.makeText(getApplicationContext(),"Invalid Inputs", Toast.LENGTH_SHORT).show();
                editText.setError("Invalid Weight");

            }
        } else {
            hideResult();
            Toast.makeText(getApplicationContext(),"Invalid Inputs", Toast.LENGTH_SHORT).show();
            editText.setError("Invalid Weight");

        }
        return weigth;
    }
}
