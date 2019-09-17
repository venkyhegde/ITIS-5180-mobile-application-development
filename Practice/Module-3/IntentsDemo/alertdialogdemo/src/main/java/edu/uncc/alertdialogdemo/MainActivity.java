package edu.uncc.alertdialogdemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    CharSequence[] colors = {"Red", "Blue", "Green"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Main Activity");

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Pick a Color")
                .setItems(colors, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        Log.d("demo", "Selected - "+colors[which]);
                    }
                })
                .setMessage("Are you sure")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // which button user clicked
                        Log.d("demo", "Clicked Ok");
                    }
                })
                .setNegativeButton("Cancel",new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // cancel button
                        Log.d("demo", "Clicked Cancel");
                    }
                });

        // create an instance of alert dialog.
        final AlertDialog alertDialog = builder.create();

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.show();
            }
        });



        //

        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);

        builder1.setTitle("Pick a Color")
                .setCancelable(false)
                .setItems(colors, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        Log.d("demo", "Selected - "+colors[which]);
                    }
                })
        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.d("demo", "CLicked Ok");
            }
        });

        final AlertDialog alertDialog2 = builder1.create();

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog2.show();
            }
        });
    }
}
