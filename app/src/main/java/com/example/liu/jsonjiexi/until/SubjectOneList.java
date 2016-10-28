package com.example.liu.jsonjiexi.until;

import android.util.Log;
import android.widget.Toast;

import org.xutils.common.Callback;


/**
 * Created by Liu on 2016/9/20.
 */
public class SubjectOneList implements Callback.CommonCallback<String> {
    private DataResult dataResult;
    public SubjectOneList(DataResult dataResult){
        this.dataResult=dataResult;
    }
    @Override
    public void onSuccess(String result) {

        Log.e("ddd",result);
        dataResult.resultList(PaeseData.getSubjectOneList(result));
    }
    @Override
    public void onError(Throwable ex, boolean isOnCallback) {

    }

    @Override
    public void onCancelled(CancelledException cex) {

    }

    @Override
    public void onFinished() {

    }

}
