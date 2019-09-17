package edu.uncc.threaddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    // declaring an ExecutorService
    ExecutorService threadPool = null;
    int num = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Thread pool demo
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // initializing thread pool
                num++;
                threadPool = Executors.newFixedThreadPool(4); //  maximum 4 threads allowed
                threadPool.execute(new DoWork());
            }
        });


        // Thread Demo
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // creating new thread
                Thread thread = new Thread(new DoWork(), "do work ");
                thread.start();
            }
        });


    }

    class DoWork implements Runnable{

        @Override
        public void run() {
            Log.d("thread1", "Thread "+num+" started!");
            for (long i=0; i<1000000000; i++){
                for (long j=0; j< 1000000000; j++){
                    for (long k=0; k<1000000000; k++){
                        for (long l=0; l<1000000000; l++){
                            some();
                        }
                    }
                }
            }
            Log.d("thread1", "Done with the work");
        }

        public void some(){
            for (long i=0; i<1000000000; i++){
                for (long j=0; j< 1000000000; j++){
                    for (long k=0; k<1000000000; k++){
                        for (long l=0; l<1000000000; l++){

                        }
                    }
                }
            }
        }
    }
}
