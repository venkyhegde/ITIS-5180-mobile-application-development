package edu.uncc.profileapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/*Assignment Group - 18
 * In Class 03
 * Akash Khiste, Venky Hegde, Chaitanya Deshpande
 * */

public class DisplayActivity extends AppCompatActivity {

    Person person = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        setTitle("My Profile");

        // get the fields
        ImageView genderImage = findViewById(R.id.imageViewDaGender);
        TextView tvFullName = findViewById(R.id.textViewDaName);
        TextView tvGender = findViewById(R.id.textViewDaGender);
        // look for intent
        if (getIntent() != null && getIntent().getExtras() != null){

            person = getIntent().getExtras().getParcelable(MainActivity.PERSON_KEY);

            if (person.getGender().equalsIgnoreCase("male")){
                genderImage.setImageDrawable(getDrawable(R.drawable.male));
            } else if (person.getGender().equalsIgnoreCase("female")){
                genderImage.setImageDrawable(getDrawable(R.drawable.female));
            }

            // set the full name and gender
            tvFullName.setText("Name: "+person.getFirstName()+" "+person.getLastName());
            tvGender.setText(person.getGender());
        }

    }

    /**
     * This method is invoked when edit button is pressed.
     * @param view
     */
    public void onEdit(View view){
        if (person == null){
            setResult(RESULT_CANCELED);
        } else {
            Intent intent = new Intent();
            intent.putExtra(MainActivity.PERSON_KEY, person);
            setResult(RESULT_OK, intent);
        }
        finish();
    }
}
