package edu.uncc.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_new);
        setTitle("Test");

        // accessing String Resources
        Log.d("Demo", getResources().getString(R.string.my_name));
        // accessing String Array
        String[] strArray = getResources().getStringArray(R.array.test_str_array);
        for (String s: strArray){
            Log.d("Demo", s);
        }
        Log.d("Demo", "Hello world activity");

        // accessing the button
        Button btn  = findViewById(R.id.amnButtonOk);
        Log.d("Demo", "Button nam is - "+btn.getText());

        // adding events approach 1
        // step 1 - get the button instance (which is as mentioned above)
        // step 2 - set on click listener on button instance.
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Demo", "OK Button Clicked");
            }
        });

// Adding events listener approach 2
        findViewById(R.id.amnButtonOther).setOnClickListener(this);


        //RADIO BUTTON

        //get radio group
        final RadioGroup rg = findViewById(R.id.radioGroup1);
        // set OnCheckedChangeListner on the radio group
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                // this method would have give id of checked radio button
                RadioButton rb = findViewById(checkedId);
                Log.d("Radio", "Checked Radio button is -"+rb.getText());

            }
        });

        // to get the checked value on clicking the button
        // 1 - set on click listener on button
        // inside the onClick method get the radio button id
        findViewById(R.id.amnButtonChecked).cancelEvent(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = rg.getCheckedRadioButtonId();
                if(id == R.id.amnRadioOk){
                    Log.d("Radio", "Checked is Ok");
                } else if (id == R.id.amnRadioCancel){
                    Log.d("Radio", "Checked is Cancel");
                } else if(id == R.id.amnRadioOther){
                    Log.d("Radio", "Checked is Other");
                } else if(id == -1){
                    Log.d("Radio", "Checked is None");
                }
            }
        });


        //SEEK BAR

        //get seek bar and get the text view
        SeekBar sb = findViewById(R.id.anmSeekBar);
        final TextView tv = findViewById(R.id.seekBarText);

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                // print the progress
                Log.d("Seek", "Progress is - "+progress);
                tv.setText(progress+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    } // end of onCreate

    // Adding events listener approach 2
    // step 1 - implement OnClickListener Interface to this activity
    // step 2 - Override onClick method and define any action
    @Override
    public void onClick(View view) {
        Log.d("Demo", "Any button clicked");
    }

    // Adding events listener approach 3
    // step 1 - define new method to handle the event.
    // step 2 - use android:onClick="" in element tag to bind this method with onClick event.
    public void cancelEvent(View view){
        Log.d("Demo", "Cancel button clicked");

        // another way of handling the event is having one method which takes View
        // differentiate the component, based on the resource id.
        if(view.getId() == R.id.amnButtonCancel){
            Log.d("Demo", "Cancel button clicked");
        } else if(view.getId() == R.id.amnButtonOk){
            Log.d("Demo", "OK button clicked");
        } else{
            Log.d("Demo", "Other button clicked");
        }
    }


}
