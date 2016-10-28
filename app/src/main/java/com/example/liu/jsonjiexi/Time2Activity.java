package com.example.liu.jsonjiexi;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;
import android.widget.Toast;
/**
 *
 * 比较常用的几个方法：
 public void setBase (long base)：设置基准时间。
 public void setFormat (String format)：设置用于显示的格式化字符串。
 public void start ():开始计时。
 public void stop ():  停止计时。
 public void setOnChronometerTickListener (Chronometer.OnChronometerTickListener listener)： 设置计时器变化时调用的监听事件。
 *
 * **/

public class Time2Activity extends AppCompatActivity {
    private Chronometer chronometer;
    private long recordtime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time2);
        chronometer= (Chronometer) findViewById(R.id.time2_time);
        //chronometer.setFormat("时间：%s");    //设置显示的格式
        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {

            }
        });

    }
    public  void start(View view){

        // chronometer.setBase(SystemClock.elapsedRealtime()-recordtime);   //跳过已经记录的时间
        chronometer.setBase(SystemClock.elapsedRealtime());                 //计时器清0
        int hour= (int) ((SystemClock.elapsedRealtime()-chronometer.getBase())/1000/60);
        chronometer.setFormat("0"+String.valueOf(hour)+":%s");
        chronometer.start();
    }
    public void stop(View view){
        chronometer.stop();
        recordtime=SystemClock.elapsedRealtime()-chronometer.getBase(); //保存这次记录的时间
    }
    public void reset(View view){
        recordtime=0;                                                     //重置时间
        chronometer.setBase(SystemClock.elapsedRealtime());



    }
}
