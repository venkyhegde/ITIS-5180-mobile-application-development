package edu.uncc.inclass4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    static int seekbarProgress = 0;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("InClass4");

        SeekBar sb = findViewById(R.id.seekBar);


        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (b)
                    seekbarProgress = i;
                TextView tv = findViewById(R.id.selectedComplexity);
                tv.setText(i+" Times");
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

    }

    public void onGenerate(View v){
        if (seekbarProgress <= 0){
            TextView min = findViewById(R.id.textViewMinAns);
            min.setText("");
            TextView max = findViewById(R.id.textViewMaxAns);
            max.setText("");
            TextView avg = findViewById(R.id.textViewAvgAns);
            avg.setText("");
            Toast.makeText(MainActivity.this, "Invalid Value", Toast.LENGTH_SHORT).show();
        } else{
            new Worker().execute(seekbarProgress);
        }

    }

    class Worker extends AsyncTask<Integer, Integer, ArrayList<Double>>{

        @Override
        protected void onPreExecute() {
            // setting up a progress dialog
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(ArrayList<Double> aDouble) {
            super.onPostExecute(aDouble);

            display(aDouble);
            progressDialog.dismiss();

        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected ArrayList<Double> doInBackground(Integer... integers) {
            ArrayList<Double> result = HeavyWork.getArrayNumbers(integers[0]);
            return result;
        }
    }

    private void display(ArrayList<Double> result) {
        TextView min = findViewById(R.id.textViewMinAns);
        TextView max = findViewById(R.id.textViewMaxAns);
        TextView avg = findViewById(R.id.textViewAvgAns);
        DecimalFormat deciFormatter = new DecimalFormat("#.########");
        String avgValue = deciFormatter.format(average(result));
        String minValue = deciFormatter.format(findMin(result));
        String maxValue = deciFormatter.format(findMax(result));

        min.setText(minValue+"");
        max.setText(maxValue+"");
        avg.setText(avgValue+"");

    }

    private double findMin(ArrayList<Double> result) {
        ArrayList<Double> sortedlist = new ArrayList<>(result);
        Collections.sort(sortedlist);
        return sortedlist.get(0);
    }

    private double findMax(ArrayList<Double> result) {
        ArrayList<Double> sortedlist = new ArrayList<>(result);
        Collections.sort(sortedlist);
        return sortedlist.get(sortedlist.size()-1);
    }

    private double average(ArrayList<Double> result) {

        double sum = 0;

        for (Double d: result){
            sum = sum + d;
        }
        return sum / result.size();
    }
}
