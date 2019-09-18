package edu.uncc.inclass04;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    ExecutorService threadPool = null;
    static int complexity = 0;
    ProgressDialog progressDialog;
    TextView tvMin, tvMax, tvAvg;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMin = findViewById(R.id.textViewMinVal);
        tvMax = findViewById(R.id.textViewMaxVal);
        tvAvg = findViewById(R.id.textViewAvgVal);

        SeekBar seekBar = findViewById(R.id.seekBar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if(b){
                    complexity = i;
                    TextView tv = findViewById(R.id.textViewTimes);
                    tv.setText(complexity+" Times");
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });


        Button btn = findViewById(R.id.buttonGenerate);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (complexity <= 0){
                    tvMin.setText("");
                    tvMax.setText("");
                    tvAvg.setText("");
                    Toast.makeText(MainActivity.this, "Invalid Complexity", Toast.LENGTH_SHORT).show();
                } else{
                    threadPool = Executors.newFixedThreadPool(2);
                    threadPool.execute(new Worker(complexity));

                    handler = new Handler(new Handler.Callback() {
                        @Override
                        public boolean handleMessage(@NonNull Message message) {
                            switch (message.what){
                                case Worker.START_STATUS:
                                    startDialog();
                                    break;
                                case Worker.STOP_STATUS:
                                    tvMin.setText(message.getData().getString(Worker.MIN_KEY));
                                    tvMax.setText(message.getData().getString(Worker.MAX_KEY));
                                    tvAvg.setText(message.getData().getString(Worker.AVG_KEY));
                                    progressDialog.dismiss();
                                    break;
                            }
                            return false;
                        }
                    });
                }
            }
        });
    }

    private void startDialog() {
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
    }


    class Worker implements Runnable{

        static final int START_STATUS = 0x00;
        static final int STOP_STATUS = 0x01;
        static final int PROGRESS_STATUS = 0x02;
        static final String RESULT_KEY = "PROGRESS";
        static final String MIN_KEY = "MIN";
        static final String MAX_KEY = "MAX";
        static final  String AVG_KEY = "AVG";

        private int n;
        public Worker(int n){
            this.n = n;
        }
        @Override
        public void run() {
            Message message = new Message();
            message.what = START_STATUS;
            handler.sendMessage(message);

            String[] result = findValues(HeavyWork.getArrayNumbers(this.n));

            message = new Message();
            Bundle bundle = new Bundle();
            bundle.putString(Worker.MIN_KEY, result[0]);
            bundle.putString(Worker.MAX_KEY, result[1]);
            bundle.putString(Worker.AVG_KEY, result[2]);
            message.setData(bundle);
            message.what = STOP_STATUS;
            handler.sendMessage(message);
        }

        private String[] findValues(ArrayList<Double> arrayNumbers) {
            String[] result = new String[3];
            DecimalFormat deciFormatter = new DecimalFormat("#.########");
            result[0] = deciFormatter.format(findMin(arrayNumbers));
            result[1] = deciFormatter.format(findMax(arrayNumbers));
            result[2] = deciFormatter.format(findAvg(arrayNumbers));
            return result;
        }

        private double findAvg(ArrayList<Double> arrayNumbers) {
            double sum = 0;

            for (Double d: arrayNumbers){
                sum = sum + d;
            }
            return sum / arrayNumbers.size();
        }

        private double findMax(ArrayList<Double> arrayNumbers) {
            ArrayList<Double> sortedlist = new ArrayList<>(arrayNumbers);
            Collections.sort(sortedlist);
            return sortedlist.get(sortedlist.size()-1);
        }

        private double findMin(ArrayList<Double> arrayNumbers) {
            ArrayList<Double> sortedlist = new ArrayList<>(arrayNumbers);
            Collections.sort(sortedlist);
            return sortedlist.get(0);
        }
    }
}
