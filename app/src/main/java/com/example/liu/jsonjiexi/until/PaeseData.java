package com.example.liu.jsonjiexi.until;

import android.util.Log;
import android.widget.Toast;

import com.example.liu.jsonjiexi.model.subjectOne;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/*
 * {
 "error_code": 0,
 "reason": "ok",
 "result": [
 {
 "id": 12,
 "question": "这个标志是何含义？",//问题
 "answer": "4",//答案
 "item1": "前方40米减速",//选项，当内容为空时表示判断题正确选项
 "item2": "最低时速40公里",//选项，当内容为空时表示判断题错误选项
 "item3": "限制40吨轴重",
 "item4": "限制最高时速40公里",
 "explains": "限制最高时速40公里：表示该标志至前方限制速度标志的路段内，机动车行驶速度不得超过标志所示数值。此标志设在需要限制车辆速度的路段的起点。以图为例：限制行驶时速不得超过40公里。",//答案解释
 "url": "http://images.juheapi.com/jztk/c1c2subject1/12.jpg"//图片url
 }
 ]
 }
 */
public class PaeseData {
    public static List<subjectOne> getSubjectOneList(String jsonstr) {
          try {
              JSONObject rootobject=new JSONObject(jsonstr);
              if(!"0".equals(rootobject.getString("error_code"))){
                  return null;
              }
              JSONArray dataAry=rootobject.getJSONArray("result");
              List<subjectOne> list=new ArrayList<subjectOne>();
              for (int i=0;i<dataAry.length();i++){
                  JSONObject detail=dataAry.getJSONObject(i);
                  String id=detail.getString("id");
                  String question=detail.getString("question");
                  String answer=detail.getString("answer");
                  String item1=detail.getString("item1");
                  String item2=detail.getString("item2");
                  String item3=detail.getString("item3");
                  String item4=detail.getString("item4");
                  String explains=detail.getString("explains");
                  String pictureurl=detail.getString("url");
                  subjectOne subjectOne=new subjectOne(id,question,answer,item1,item2,item3,item4,explains,pictureurl);
                  list.add(subjectOne);

              }
              return list;
          } catch (JSONException e) {
              e.printStackTrace();
              return null;
          }
    }
}
