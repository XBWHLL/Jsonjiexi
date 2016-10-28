package com.example.liu.jsonjiexi.adapt;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.liu.jsonjiexi.R;

/**
 * Created by Liu on 2016/9/26.
 */
public class GridviewAdapt extends BaseAdapter {
    private Context context;
    private int[] imgs;

    public GridviewAdapt(Context context, int[] imgs) {
        this.context = context;
        this.imgs = imgs;
    }

    @Override
    public int getCount() {
        return imgs.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return imgs[position];
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if(null==convertView){
            convertView=LayoutInflater.from(context).inflate(R.layout.gridview_image_layout,null);
//            //设置ImageView对象布局
//            imgs.setLayoutParams(new GridView.LayoutParams(45,45));
//            //设置边界对齐
//            imgs.setAdjustViewBounds(false);
//            //设置刻度类型
//            imgs.setScaleType(ImageView.ScaleType.CENTER_CROP);
//            //设置间距
//            imgs.setPadding(8,8,8,8);
            holder=new ViewHolder();

            holder.imageView= (ImageView) convertView.findViewById(R.id.gridview_img);
            convertView.setTag(holder);
        }
        else {
            holder= (ViewHolder) convertView.getTag();
        }
        holder.imageView.setImageResource(imgs[position]);
        return convertView;
    }
    static class ViewHolder{
        ImageView imageView;
    }
}
