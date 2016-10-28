package com.example.liu.jsonjiexi.until;

import com.example.liu.jsonjiexi.model.subjectOne;

import java.util.List;

/**
 * Created by Liu on 2016/9/20.
 */
public interface DataResult {
    /**
     * 网络数据结果处理为对象
     * @param obj
     */
    void resultObject(Object obj) ;


    /**
     * 网络数据处理结果为集合
     * @param list
     */
    void resultList(List<subjectOne> list) ;

}
