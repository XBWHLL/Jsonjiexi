package com.example.liu.jsonjiexi.until;

import org.xutils.common.Callback;

/**
 * Created by Liu on 2016/9/20.
 */
public interface IHttpServer {

    void getSubjectOneList(String subject,String model,String testType ,Callback.CommonCallback<String> Callback );

}
