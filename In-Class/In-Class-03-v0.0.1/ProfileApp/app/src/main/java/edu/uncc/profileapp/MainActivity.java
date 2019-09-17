package edu.uncc.profileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static String gender;
    static  String PERSON_KEY = "person";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("My Profile");

        final ImageView genderImage = findViewById(R.id.imageViewDp);
        final RadioGroup rg = findViewById(R.id.radioGroupGen);

        // handling radio button
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                if (id == R.id.radioButtonFm){
                    genderImage.setImageDrawable(getDrawable(R.drawable.female));
                    gender = "Female";
                } else if (id == R.id.radioButtonM){
                    genderImage.setImageDrawable(getDrawable(R.drawable.male));
                    gender = "Male";
                }
            }
        });
    } // end of on create

    // on click save
    public void onSave(View view){
        // get the first name, last name and gender
        EditText edFirstName = findViewById(R.id.editTextFn);
        EditText edLastName = findViewById(R.id.editTextLn);



       if(validate(edFirstName, edLastName)){
           String firstName = edFirstName.getText().toString().trim();
           String lastName = edLastName.getText().toString().trim();

           Person person = new Person(firstName, lastName, gender);
           Intent intent = new Intent(getBaseContext(), DisplayActivity.class);
           intent.putExtra(PERSON_KEY, person);
           startActivity(intent);
           finish();
       }



    }

    private boolean validate(EditText edFirstName, EditText edLastName) {

        String firstName = edFirstName != null ? edFirstName.getText().toString().trim():"";
        String lastName = edLastName != null ? edLastName.getText().toString().trim(): "";

        // validate fn & ln
        if (firstName.length() <= 0 && lastName.length() <= 0){
            edFirstName.setError("Invalid Value");
            edLastName.setError("Invalid Value");
            return false;
        } else if(firstName.length() <=0 ){
            edFirstName.setError("Invalid Value");
            return false;
        } else if (lastName.length() <= 0){
            edLastName.setError("Invalid Value");
            return false;
        }

        RadioButton rb1 = findViewById(R.id.radioButtonFm);
        RadioButton rb2 = findViewById(R.id.radioButtonM);

        if (!rb1.isChecked() && !rb2.isChecked())
        {
            Toast.makeText(getBaseContext(), "Invalid Gender", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

}
