package com.example.liu.jsonjiexi;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TimeActivity extends AppCompatActivity {
    private int recLen = 0;
    private TextView txtView;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_time);
        txtView = (TextView)findViewById(R.id.time_time);

        new Thread(new MyThread()).start();         // start thread
    }

    final Handler handler = new Handler(){          // handle
        public void handleMessage(Message msg){
            switch (msg.what) {
                case 1:
                    recLen++;
                    txtView.setText("时间为：" + recLen/60+":"+recLen%60);
            }
            super.handleMessage(msg);
        }
    };

    public class MyThread implements Runnable{      // thread
        @Override
        public void run(){
            while(true){
                try{
                    Thread.sleep(1000);     // sleep 1000ms
                    Message message = new Message();
                    message.what = 1;
                    handler.sendMessage(message);
                }catch (Exception e) {
                }
            }
        }
    }
}
