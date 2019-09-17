package edu.uncc.pizzastore;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.gridlayout.widget.GridLayout;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> selectedToppings = new ArrayList<>(10);
    ProgressBar progressBar;
    ImageButton imageButton;
    GridLayout toppingLayout;
    boolean isDevlivery = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.toppingsProgress);
        progressBar.setProgress(0);

        toppingLayout = findViewById(R.id.toppingLayout);
        toppingLayout.removeAllViews();

        int total = 10;
        int column = 5;
        int row = total / column;
        toppingLayout.setColumnCount(column);
        toppingLayout.setRowCount(row);

        CheckBox checkBox = findViewById(R.id.checkBoxDelivery);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                isDevlivery = b;
            }
        });
    }

    public void addToppings(View view){

        // alert dialog / add toppings
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity.this);
        dialogBuilder.setTitle("Choose a Topping")
                .setCancelable(false)
                .setItems(getResources().getStringArray(R.array.toppings_array), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                        if(selectedToppings.size() < 10){
                            Log.d("demo",
                                    "Before Adding - "+getResources().getStringArray(R.array.toppings_array)[which]+" Size -"+selectedToppings.size());
                            selectedToppings.add(getResources().getStringArray(R.array.toppings_array)[which]);
                            progressBar.setProgress(selectedToppings.size() * 10);
                            //TODO: add topping to view
                            addToppings(which);
                            Log.d("demo",
                                    "After Adding Size -"+selectedToppings.size());
                        } else{
                            Toast.makeText(MainActivity.this, "Maximum Topping capacity reached!"
                                    , Toast.LENGTH_SHORT).show();
                        }
                    }
                });

        final AlertDialog toppingsDialog = dialogBuilder.create();
        toppingsDialog.show();
        // alert dialog/ add toppings ends
    }

    public void clearPizza(View view){
        toppingLayout = findViewById(R.id.toppingLayout);
        toppingLayout.removeAllViews();
        selectedToppings.clear();
        progressBar = findViewById(R.id.toppingsProgress);
        progressBar.setProgress(0);
    }

    private void addToppings(int which) {
        String imageName = getResources().getStringArray(R.array.toppings_icon)[which];
        int imageId = getResources().getIdentifier(imageName, "drawable", this.getPackageName());

        imageButton = new ImageButton(MainActivity.this);
        imageButton.setId(which+1);
        imageButton.setPadding(0,0,0,0);
        imageButton.setScaleType(ImageView.ScaleType.FIT_XY);
        imageButton.setImageResource(imageId);

        GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams();
        layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        layoutParams.width = ViewGroup.LayoutParams.WRAP_CONTENT;
        layoutParams.setMargins(16,8,16,8);
        layoutParams.setGravity(Gravity.CENTER_HORIZONTAL);
        imageButton.setLayoutParams(layoutParams);

        toppingLayout.addView(imageButton);

    }

}
