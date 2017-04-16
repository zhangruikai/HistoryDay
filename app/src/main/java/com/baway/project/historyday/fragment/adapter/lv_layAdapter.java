package com.baway.project.historyday.fragment.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baway.project.historyday.R;
import com.baway.project.historyday.bean.Lay_lv_Bean;

import java.util.List;

/**
 * Created by 张瑞凯 on 2017/3/17.
 */
public class lv_layAdapter extends BaseAdapter {


    List<Lay_lv_Bean> list;
    Context context;

    public lv_layAdapter(List<Lay_lv_Bean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View converView, ViewGroup viewGroup) {

        ViewHolder viewHolder;

        if(converView==null){
            viewHolder=new ViewHolder();
            converView=View.inflate(context, R.layout.lay_lv_adapter,null);
            converView.setTag(viewHolder);
            viewHolder.lay_img = (ImageView) converView.findViewById(R.id.lay_img);
            viewHolder.tvToday = (TextView) converView.findViewById(R.id.tvToday);
        }else{

            viewHolder= (ViewHolder) converView.getTag();


        }


        viewHolder.tvToday.setText(list.get(position).getName());

        viewHolder.lay_img.setImageResource(list.get(position).getImg());




        return converView;
    }


    class ViewHolder{

       TextView tvToday;
        ImageView lay_img;



    }

}
