package edu.uncc.handlerdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    //1. declaring a handler
    Handler handler;

    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Progress...");
        progressDialog.setMax(100);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setCancelable(false);

        //2. instantiating new handler, with callback
        handler = new Handler(new Handler.Callback() {
            // callback method receives message from child thread
            @Override
            public boolean handleMessage(@NonNull Message message) {
                switch (message.what) {
                    case Worker.START_STATUS:
                        progressDialog.setProgress(0);
                        progressDialog.show();
                        Log.d("handler","Start ..... "+message.what );
                        break;
                    case Worker.PROGRESS_STATUS:
                        progressDialog.setProgress(message.getData().getInt(Worker.PROGRESS_KEY));
                        Log.d("handler","Progress ..... "+ message.getData().getInt(Worker.PROGRESS_KEY) );
                        break;
                    case Worker.STOP_STATUS:
                        progressDialog.dismiss();
                        Log.d("handler","Stop ..... "+message.what );
                        break;
                }
                return false;
            }
        });

        // 3. schedule a thread
        new Thread(new Worker()).start();
    }


    // creating a runnable class
    class Worker implements Runnable {
        static final int START_STATUS = 0x00;
        static final int STOP_STATUS = 0x01;
        static final int PROGRESS_STATUS = 0x02;
        static final String PROGRESS_KEY = "PROGRESS";

        @Override
        public void run() {
            Message startMessage = new Message();
            startMessage.what = START_STATUS;
            handler.sendMessage(startMessage);

            for (int i = 0; i < 101; i++) {
                for (int j = 0; j < 100000000; j++) {
                }

                Message progressMsg = new Message();
                progressMsg.what = PROGRESS_STATUS;

                Bundle bundle = new Bundle();
                bundle.putInt(PROGRESS_KEY, i);
                progressMsg.setData(bundle);

                handler.sendMessage(progressMsg);
            }
            Message stopMessage = new Message();
            stopMessage.what = STOP_STATUS;
            handler.sendMessage(stopMessage);
        }
    }// end of Worker class
}
