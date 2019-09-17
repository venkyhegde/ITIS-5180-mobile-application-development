package edu.uncc.profileapplication;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/*Assignment Group - 18
 * In Class 03
 * Akash Khiste, Venky Hegde, Chaitanya Deshpande
 * */

public class MainActivity extends AppCompatActivity {

    private static StringBuilder gender = null;
    static String PERSON_KEY = "PERSON";
    static int REQ_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("My Profile");

        // getting all view components
        final ImageView genderImage  = findViewById(R.id.imageViewGender);
        RadioGroup radioGroup = findViewById(R.id.radioGroup1);

        // tracking the radio button changes
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int radioId) {
                if (R.id.radioButtonM == radioId){
                    //male
                    genderImage.setImageDrawable(getDrawable(R.drawable.male));
                    gender = new StringBuilder("Male");
                } else if (R.id.radioButtonF == radioId){
                    // female
                    genderImage.setImageDrawable(getDrawable(R.drawable.female));
                    gender = new StringBuilder("Female");
                }
            }
        });

    }

    /**
     * Method to validate inputs
     * @param eTfirstName
     * @param eTlastName
     * @param gender
     * @return true if all fields are valid, else false.
     */
    private boolean validateInputs(EditText eTfirstName, EditText eTlastName, StringBuilder gender) {
        boolean isValid = true;
        // check if first name and last name are empty
        if (eTfirstName != null && eTfirstName.getText().toString().trim().isEmpty()){
            eTfirstName.setError("Invalid First Name");
            isValid = false;
        }

        if (eTlastName != null && eTlastName.getText().toString().trim().isEmpty()){
            eTlastName.setError("Invalid Last Name");
            isValid = false;
        }


        if (gender == null || gender.toString().trim().isEmpty()){
            Toast.makeText(getBaseContext(), "Invalid Gender", Toast.LENGTH_LONG).show();
            isValid = false;
        }

        return isValid;
    }

    /**
     * This method is invoked after clicking save button
     * @param view
     */
    public void onSave(View view){
        // getting first name, last name
        EditText eTfirstName = findViewById(R.id.editTextFn);
        EditText eTlastName = findViewById(R.id.editTextLn);

        if (validateInputs(eTfirstName, eTlastName, gender)){
            // creating person object
            Person person = new Person(eTfirstName.getText().toString().trim(),
                    eTlastName.getText().toString().trim(), gender.toString());
            Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
            intent.putExtra(PERSON_KEY, person);
            startActivityForResult(intent, REQ_CODE);
        }
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
        if (requestCode == REQ_CODE){
            if (resultCode == RESULT_OK){
                Person person = data.getExtras().getParcelable(MainActivity.PERSON_KEY);

                EditText ed = findViewById(R.id.editTextFn);
                ed.setText(person.getFirstName());
                ed = findViewById(R.id.editTextLn);
                ed.setText(person.getLastName());

                ImageView genImage  = findViewById(R.id.imageViewGender);

                if (person.getGender().equalsIgnoreCase("male")){
                    genImage.setImageDrawable(getDrawable(R.drawable.male));
                    RadioButton rb = findViewById(R.id.radioButtonM);
                    rb.setChecked(true);
                } else if (person.getGender().equalsIgnoreCase("female")){
                    genImage.setImageDrawable(getDrawable(R.drawable.female));
                    RadioButton rb = findViewById(R.id.radioButtonF);
                    rb.setChecked(true);
                }

            } else if (resultCode == RESULT_CANCELED){
                Log.e("Error", "Person data not received");
            }
        }
    } // end of onActivityResult
}
