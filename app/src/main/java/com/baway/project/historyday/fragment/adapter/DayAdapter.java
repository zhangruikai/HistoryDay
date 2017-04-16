package com.baway.project.historyday.fragment.adapter;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baway.project.historyday.R;
import com.baway.project.historyday.bean.DayBean;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by 张瑞凯 on 2017/3/16.
 */

public class DayAdapter extends RecyclerView.Adapter<DayAdapter.MyViewHolder>{
    List<DayBean.ResultBean> list=new ArrayList<>();
    Context context;
    private OnItemClickListener mOnItemClickListener;
    public DayAdapter(Context context, List<DayBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }
    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }
    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @Override
    public DayAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.day_fragment_adapter, parent, false);
            MyViewHolder holder=new MyViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(final DayAdapter.MyViewHolder holder, int position) {
        holder.tv_time.setText(list.get(position).getDate());
        holder.tv_title.setText(list.get(position).getTitle());

        if(mOnItemClickListener != null){
            //为ItemView设置监听器
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getLayoutPosition(); // 1
                    mOnItemClickListener.onItemClick(holder.itemView,position-1); // 2
                }
            });
        }

    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {
     TextView tv_time,tv_title;
      public MyViewHolder(View itemView) {
          super(itemView);
          tv_time = (TextView) itemView.findViewById(R.id.tv_time);
          tv_title = (TextView) itemView.findViewById(R.id.tv_title);
      }
    }
}