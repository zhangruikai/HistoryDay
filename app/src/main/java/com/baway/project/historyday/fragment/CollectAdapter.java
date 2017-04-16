package com.baway.project.historyday.fragment;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baway.project.historyday.R;
import com.baway.project.historyday.dbutils.DBBean;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by 张瑞凯 on 2017/3/30.
 */
public class CollectAdapter extends BaseAdapter {

    List<DBBean> list;
    Context context;

    public CollectAdapter(List<DBBean> list, Context context) {
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
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = View.inflate(context, R.layout.favorities_item, null);
            convertView.setTag(viewHolder);
            viewHolder.tv_date = (TextView) convertView.findViewById(R.id.tv_collect_date);
            viewHolder.tv_title = (TextView) convertView.findViewById(R.id.tv_collect_title);
            viewHolder.img = (ImageView) convertView.findViewById(R.id.img_collect);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tv_date.setText(list.get(position).getDate());
        viewHolder.tv_title.setText(list.get(position).getTitle());
        Glide.with(context).load(list.get(position).getPicurl()).into(viewHolder.img);

        return convertView;
    }

    class ViewHolder{
        TextView tv_date;
        TextView tv_title;
        ImageView img;
    }


}
