package com.example.liu.jsonjiexi.until;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by Liu on 2016/9/20.
 */

public class HttpServer implements IHttpServer {

    public void getSubjectOneList(String subject, String model, String testType,Callback.CommonCallback<String> callback) {
        RequestParams params=new RequestParams(UrlUtil.subjectOne_URL);
        params.addQueryStringParameter(UrlUtil.Subject, subject);
        params.addQueryStringParameter(UrlUtil.Model,model);
        params.addQueryStringParameter(UrlUtil.TestType,testType);
        x.http().get(params,callback);

    }

}
