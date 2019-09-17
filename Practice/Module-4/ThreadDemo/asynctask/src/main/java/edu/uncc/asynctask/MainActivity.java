package edu.uncc.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Main Activity");
        Log.d("async", "onCreate, thread id is - "+Thread.currentThread().getId());
        new DoWork().execute(1000000);
    }
    class DoWork extends AsyncTask<Integer, Integer, Double>{

        @Override
        protected void onPreExecute() {
            Log.d("async", "onPreExecute thread id is - "+Thread.currentThread().getId());

            // setting up a progress dialog
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setMessage("Progress...");
            progressDialog.setMax(100);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected Double doInBackground(Integer... values) {
            Log.d("async", "doInBackground thread id is - "+Thread.currentThread().getId());
            int count = 0;
            double sum = 0;
            Random rand  = new Random();
            for (int i=0; i< 100; i++){
                for (int j=0; j<values[0]; j++){
                    sum = rand.nextDouble() + sum;
                    count++;
                }
                publishProgress(i); // publishing the progress
            }
            return sum / count;
        }

        @Override
        protected void onPostExecute(Double aDouble) {
            Log.d("async", "onPostExecute thread id is - "+Thread.currentThread().getId());
            Log.d("async", "Value returned from doInBackground = "+aDouble);
            progressDialog.dismiss();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            Log.d("async", "onProgressUpdate thread id is - "+Thread.currentThread().getId());

            progressDialog.setProgress(values[0]);
        }
    }
}
