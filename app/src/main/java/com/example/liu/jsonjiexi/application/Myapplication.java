package com.example.liu.jsonjiexi.application;

import android.app.Application;
import org.xutils.x;

/**
 * Created by Liu on 2016/9/20.
 */
public class Myapplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(true);
    }
}
