package edu.uncc.profileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    Person person = null;
    static  String PERSON_KEY = "person";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        setTitle("My Profile");

        TextView fullNameTv = findViewById(R.id.tvFullName);
        TextView genderTv = findViewById(R.id.tvGender);
        ImageView imageView = findViewById(R.id.imageViewDisplay);

        fullNameTv.setVisibility(View.INVISIBLE);
        genderTv.setVisibility(View.INVISIBLE);


        if(getIntent() != null && getIntent().getExtras()!= null){
             person = getIntent().getExtras().getParcelable(MainActivity.PERSON_KEY);
            if(person.getGender().equalsIgnoreCase("male")){
                imageView.setImageDrawable(getDrawable(R.drawable.male));
            } else if (person.getGender().equalsIgnoreCase("female")){
                imageView.setImageDrawable(getDrawable(R.drawable.female));

            }

            fullNameTv.setText("Name: "+person.getFirstName() +" "+person.getLastName());
            genderTv.setText(person.getGender());
            fullNameTv.setVisibility(View.VISIBLE);
            genderTv.setVisibility(View.VISIBLE);

        } // end of if




    } // end of onCreate

    public void onEdit(View view){
        Intent intent = new Intent(getBaseContext(), EditActivity.class);
        intent.putExtra(PERSON_KEY, person);
        startActivity(intent);
        finish();
    }
}
