package edu.uncc.areacalculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 *  In class Assignment 2
 *
 *  MainActivity.java
 *
 *  Venky Shantharam Hegde,
 *  Akash Atul Khiste,
 *  Chaitanya Deshpande
 */
public class MainActivity extends AppCompatActivity {

    private String shapeSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Area Calculator");

        // before selecting the shape lengths are invisible
        findViewById(R.id.editTextLen1).setVisibility(View.INVISIBLE);
        findViewById(R.id.editTextLen2).setVisibility(View.INVISIBLE);
    }

    /**
     * Mathod to handle image clicks and set appropriate length
     * @param view
     */
    public void imageClick(View view) {
        // get the image id
        int id = view.getId();
        TextView tv = findViewById(R.id.textViewSelectedShape);

        if(id == R.id.imageViewTri){
            // if triangle is selected, both length's must be visible
            findViewById(R.id.editTextLen1).setVisibility(View.VISIBLE);
            findViewById(R.id.editTextLen2).setVisibility(View.VISIBLE);
            // set text
            tv.setText("Triangle");
            shapeSelected = "triangle";

        } else if(id == R.id.imageViewCir){
            // if circle is selected only Length1 will be visible
            findViewById(R.id.editTextLen1).setVisibility(View.VISIBLE);
            // set text to circle
            tv.setText("Cirlce");
            shapeSelected = "circle";
        } else {
            // when square is selected only length 1 will be visible
            findViewById(R.id.editTextLen1).setVisibility(View.VISIBLE);
            //set text
            tv.setText("Square");
            shapeSelected = "square";
        }

    }

    /**
     * Method to calculate area
     * @param view
     */
    public void calculateClick(View view){
        // get length1 and length 2

        EditText len1 = findViewById(R.id.editTextLen1);
        EditText len2 = findViewById(R.id.editTextLen2);

        double area = 0.0;
        if(shapeSelected == "circle"){
            if(len1.getText().toString().isEmpty()){
                len1.setError("Enter valid Radius");
            } else{
                float length1 = Float.parseFloat(len1.getText().toString());
                if (length1 <= 0)
                    len1.setError("Enter valid Radius");
                else
                    area = 3.1416 * length1 * length1;
            }


        } else if(shapeSelected == "triangle"){
            if (len1.getText().toString().isEmpty() && len2.getText().toString().isEmpty()){
                len1.setError("Enter valid Length");
                len2.setError("Enter valid Length");
            } else if(len1.getText().toString().isEmpty()){
                len1.setError("Enter valid Length");
            } else if(len2.getText().toString().isEmpty()){
                len2.setError("Enter valid Length");
            } else {
                float length1 = Float.parseFloat(len1.getText().toString());
                float length2 = Float.parseFloat(len2.getText().toString());
                if (length1 <= 0 || length2 <= 0){
                    len1.setError("Enter valid Length");
                    len2.setError("Enter valid Length");
                } else {
                    area = 0.5 * length1 * length2;
                }

            }

        } else {

            if(len1.getText().toString().isEmpty()){
                len1.setError("Enter valid Radius");
            } else{
                float length1 = Float.parseFloat(len1.getText().toString());
                if (length1 <= 0)
                    len1.setError("Enter valid Radius");
                else
                    area = length1 * length1;
            }

        }

        TextView answearText = findViewById(R.id.textViewArea);
        answearText.setText(area+"");
    }

    /**
     * Method to clear
     * @param view
     */
    public void clear(View view){
        // when clear is pressed
        // clearing the selected shape
        TextView tv = findViewById(R.id.textViewSelectedShape);
        tv.setText(getResources().getString(R.string.selectedShapedText));
        // making length1 and legth 2 invisible
        findViewById(R.id.editTextLen1).setVisibility(View.INVISIBLE);
        findViewById(R.id.editTextLen2).setVisibility(View.INVISIBLE);
        //reset the value of length1 and Length2
        EditText et = findViewById(R.id.editTextLen1);
        et.setText("");
        et = findViewById(R.id.editTextLen2);
        et.setText("");
        // clearing the result
        tv = findViewById(R.id.textViewArea);
        tv.setText("");
    }
}
