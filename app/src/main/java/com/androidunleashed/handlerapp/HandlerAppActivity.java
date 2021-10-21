package com.androidunleashed.handlerapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.os.Handler;
import android.os.Message;

public class HandlerAppActivity extends Activity {
    TextView seqView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_app);
        seqView=(TextView)findViewById(R.id.sequenceview);
    }

     Handler handler = new Handler() ;


    String s="";
    @Override
    protected void onStart() {
        super.onStart();

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<=100;i++) {
                    try {
                        Thread.sleep(3000);
                        s=""+i;
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                seqView.setText(""+s);
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }
}
