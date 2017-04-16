package com.baway.project.historyday.fragment.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.baway.library.glide.GlideUtils;
import com.baway.project.historyday.R;
import com.baway.project.historyday.activity.ImageViewShow;
import com.baway.project.historyday.bean.MMbean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张瑞凯 on 2017/3/16.
 */
public class MMAdapter extends RecyclerView.Adapter<MMAdapter.MyViewHolder> {

            List<MMbean.ResultsBean> list=new ArrayList<>();
            Context context;
    public MMAdapter(Context context, List<MMbean.ResultsBean> list) {
        this.context = context;
        this.list = list;
    }
    @Override
    public MMAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.mm_fragment_adapter, parent, false);
            MyViewHolder holder=new MyViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(final MMAdapter.MyViewHolder holder, int position) {
        final MMbean.ResultsBean bean = list.get(position);
        GlideUtils.loadImage(context,bean.url,holder.img);
            holder.img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(context, ImageViewShow.class);

                    intent.putExtra("img",bean.url);

                    context.startActivity(intent);
                }
            });
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

  class MyViewHolder extends RecyclerView.ViewHolder{
      ImageView img;
      public MyViewHolder(View itemView) {
          super(itemView);
          img = (ImageView) itemView.findViewById(R.id.img);
      }
  }
}
