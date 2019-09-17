package edu.uncc.profileapp;

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

public class EditActivity extends AppCompatActivity {
    Person person = null;
    static  String PERSON_KEY = "person";
    static String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        setTitle("My Profile");

        EditText fnEd = findViewById(R.id.editTextFn1);
        EditText lnEd = findViewById(R.id.editTextLn1);
        ImageView profileImage = findViewById(R.id.imageViewDp1);
        RadioGroup rg = findViewById(R.id.radioGroupGen1);
        final ImageView genderImage = findViewById(R.id.imageViewDp1);



        if (getIntent() != null && getIntent().getExtras() != null){
             person = getIntent().getExtras().getParcelable(DisplayActivity.PERSON_KEY);

             if (person.getGender().trim().equalsIgnoreCase("male")){
                 profileImage.setImageDrawable(getDrawable(R.drawable.male));
                RadioButton rb =  findViewById(R.id.radioButtonM1);
                rb.setChecked(true);
             } else if (person.getGender().trim().equalsIgnoreCase("female")){
                 profileImage.setImageDrawable(getDrawable(R.drawable.female));
                 RadioButton rb =  findViewById(R.id.radioButtonFm1);
                 rb.setChecked(true);
             }
            fnEd.setText(person.getFirstName());
            lnEd.setText(person.getLastName());
            gender = person.getGender();
        }

        // handling radio button
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                if (id == R.id.radioButtonFm1){
                    genderImage.setImageDrawable(getDrawable(R.drawable.female));
                    gender = "Female";
                } else if (id == R.id.radioButtonM1){
                    genderImage.setImageDrawable(getDrawable(R.drawable.male));
                    gender = "Male";
                }
            }
        });
    } // end of on create


    public void onSave(View view){
        // get the first name, last name and gender
        EditText edFirstName = findViewById(R.id.editTextFn1);
        EditText edLastName = findViewById(R.id.editTextLn1);

        if(validate(edFirstName, edLastName)){
            String firstName = edFirstName.getText().toString().trim();
            String lastName = edLastName.getText().toString().trim();
            Log.d("demo", firstName);
            Log.d("demo", lastName);

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

        RadioButton rb1 = findViewById(R.id.radioButtonFm1);
        RadioButton rb2 = findViewById(R.id.radioButtonM1);

        if (!rb1.isChecked() && !rb2.isChecked())
        {
            Toast.makeText(getBaseContext(), "Invalid Gender", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
