package com.example.liu.jsonjiexi;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.liu.jsonjiexi.model.subjectOne;
import com.example.liu.jsonjiexi.until.DataResult;
import com.example.liu.jsonjiexi.until.HttpServer;
import com.example.liu.jsonjiexi.until.SubjectOneList;
import com.example.liu.jsonjiexi.until.UrlUtil;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DataResult {
    private TextView tvNumber,tvQuestion,tvSelect1,tvSelect2,tvSelect3,tvSelect4;
    private ImageView ivImg;
    private Button button1,button2;
    RequestParams params;
    int id=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvNumber= (TextView) findViewById(R.id.main_number);
        tvQuestion= (TextView) findViewById(R.id.main_quertion);
        tvSelect1= (TextView) findViewById(R.id.main_select1);
        tvSelect2= (TextView) findViewById(R.id.main_select2);
        tvSelect3= (TextView) findViewById(R.id.main_select3);
        tvSelect4= (TextView) findViewById(R.id.main_select4);
        ivImg= (ImageView) findViewById(R.id.main_img);
        button1= (Button) findViewById(R.id.main_button1);
        button2= (Button) findViewById(R.id.main_button2);

        new HttpServer().getSubjectOneList("1","c2","order",new SubjectOneList(this));
        //new HttpServer().getSubjectOneList("1","c1","rand",new SubjectOneList(this));
    }

    public void resultObject(Object obj) {

    }

    public  void resultList(final List<subjectOne> list) {
        //Log.e("--------------",list.get(0).toString());
        tvNumber.setText(list.get(id).getId());
        tvQuestion.setText(list.get(id).getQuestion());

        //将网络解析的地址给换成图片
        ImageOptions option=new ImageOptions.Builder()
                .setFailureDrawableId(R.mipmap.ic_launcher)
                .setLoadingDrawableId(R.mipmap.ic_launcher)
                //.setSize(40,40)
                .setFadeIn(true)
                .build();
        x.image().bind(ivImg,list.get(id).getPictureurl(),option);

        tvSelect1.setText(list.get(id).getItem1());
        tvSelect2.setText(list.get(id).getItem2());
        tvSelect3.setText(list.get(id).getItem3());
        tvSelect4.setText(list.get(id).getItem4());
    }
}
