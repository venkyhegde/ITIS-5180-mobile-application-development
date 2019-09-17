package edu.uncc.dynamiclayout;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*setContentView(R.layout.activity_main);*/

        // creating dynamic layout

        //step 1. Create the Layout instance
        RelativeLayout relativeLayout = new RelativeLayout(this);
        // step 2. Set the layout parameters using setLayoutParams() method
        // setting width and height to Match parent
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        // step 3. set the layout for activity
        setContentView(relativeLayout);

        // adding view component to Layout

        // adding an text view
        // step 1. create a text view instance
        TextView textView1 = new TextView(this);
        // step 2. adding properties
        textView1.setText(R.string.app_name);
        textView1.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT));
        textView1.setId(View.generateViewId());
        // step 3. adding this view to layout
        relativeLayout.addView(textView1);


        // Adding a button below this text view
        // step 1 - Create a view
        Button button1 = new Button(this);
        button1.setText(R.string.click_me);
        // step 2 - set layout parameters
        RelativeLayout.LayoutParams buttonLayout =
                new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
        buttonLayout.addRule(RelativeLayout.BELOW, textView1.getId());
        // above buttonLayout.addRule(verb, subject);
        // verb - position, below, above etc. subject is another view component.
        // step 3 - register layout with component
        button1.setLayoutParams(buttonLayout);
        // step 4 - add this component to view
        relativeLayout.addView(button1);

    }
}
