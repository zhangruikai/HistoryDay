package com.baway.project.historyday.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.baway.library.okhttp.HttpCallBack;
import com.baway.library.okhttp.NetHttpUtils;
import com.baway.project.historyday.R;
import com.baway.project.historyday.activity.Detail;
import com.baway.project.historyday.bean.DayBean;
import com.baway.project.historyday.fragment.adapter.DayAdapter;
import com.baway.project.historyday.utils.CircleCalendarActivity;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
/**
 * 
 * @author 张瑞凯
 * @description 今日
 */
public class TodayFragment extends Fragment{
	private View view;
	private List<DayBean.ResultBean> list;
	private XRecyclerView recycle;
	private int page=1;
	private LinearLayoutManager manager;
	private String nowTime;
	private Button iv_rili_view;
	private int year;
	private int month;
	private int day;
	private TextView toa_month;
	private TextView toa_day;
	private TextView toa_year;
	private DayAdapter adapter;
	private ImageView today_left;
	private ImageView today_right;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		init();
		clardler();
		initdata(month,day);
		onClicke();
		SubString();
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.frag_today, null);
		return view;
	}
	public void init(){

		today_left = (ImageView) view.findViewById(R.id.today_left);
		today_right = (ImageView) view.findViewById(R.id.today_right);
		toa_month = (TextView) view.findViewById(R.id.toa_month);
		toa_day = (TextView) view.findViewById(R.id.toa_day);
		toa_year = (TextView) view.findViewById(R.id.toa_year);
		iv_rili_view = (Button) view.findViewById(R.id.iv_rili_view);
		recycle = (XRecyclerView) view.findViewById(R.id.recycle);

		 manager=  new LinearLayoutManager(getActivity());
		manager.setOrientation(LinearLayoutManager.VERTICAL);
		recycle.setLayoutManager(manager);
		recycle.setLoadingListener(new XRecyclerView.LoadingListener() {
			@Override
			public void onRefresh() {
				initdata(month,day);
				toa_day.setText(day+"日");
				recycle.refreshComplete();
				day++;
				if(day==31){
					day=1;
					month+=1;
				} if(month==12){
					month++;
					day=1;
					year++;
				}
				toa_month.setText(month+"月");
				toa_year.setText(year+"年");
			}
			@Override
			public void onLoadMore() {
				initdata(month,day);
				toa_day.setText(day+"日");
				recycle.loadMoreComplete();
				day++;
				if(day==31){
					day=1;
					month++;
				} if(month==12){
					month=1;
					day=1;
					year++;
				}
				toa_month.setText(month+"月");
				toa_year.setText(year+"年");
			}
		});
	}
	public void onClicke() {

		iv_rili_view.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent=new Intent(getActivity(), CircleCalendarActivity.class);
				startActivity(intent);
			}
		});


		today_right.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				day++;
				initdata(month,day);
				toa_day.setText(day+"日");
				recycle.refreshComplete();
				if(day==31){
					day=1;
					month+=1;
				} if(month==12){
					month++;
					day=1;
					year++;
				}
				toa_month.setText(month+"月");
				toa_year.setText(year+"年");
			}
		});

		today_left.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				day--;
				initdata(month,day);
				toa_day.setText(day+"日");
				recycle.refreshComplete();
				if(day==1){
					day=30;
					month-=1;
				} if(month==1){
					month=12;
					day=30;
					year--;
				}
				toa_month.setText(month+"月");
				toa_year.setText(year+"年");
			}
		});
	}

	private void clardler(){
		Calendar c= Calendar.getInstance();
		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH)+1;
		day = c.get(Calendar.DAY_OF_MONTH);
		toa_day.setText(day+"日");
		toa_month.setText(month+"月");
		toa_year.setText(year+"年");
	}
	private void SubString(){
		Intent intent=getActivity().getIntent();
		String date =  intent.getStringExtra("date");
		int id =  intent.getIntExtra("idt",0);
		if(id==2){
			String[] temp=null;
			temp = date.split("-");
			//拆分月份
			temp[1].charAt(1);
			toa_day.setText(temp[2]+"日");
			toa_month.setText(temp[1]+"月");
			toa_year.setText(temp[0]+"年");
			initdata(Integer.valueOf(temp[1]),Integer.valueOf(temp[2]));

		}
	}
	private void initdata(int month,int day){
		String url="http://v.juhe.cn/todayOnhistory/queryEvent.php?key=69a7eeba7869f8bdcdee7b2bc3bb5aa2&date="+month+"/"+day;
		NetHttpUtils.getInstance().get(getActivity(), url, null, new HttpCallBack<DayBean>() {
			@Override
			public void success(DayBean o) {
				list = o.getResult();
				adapter = new DayAdapter(getActivity(), list);

				adapter.setOnItemClickListener(new DayAdapter.OnItemClickListener() {
					@Override
					public void onItemClick(View view, int position) {

						Intent intent=new Intent(getActivity(),Detail.class);

						intent.putExtra("qid",list.get(position).getE_id());
						intent.putExtra("datee",list.get(position).getDate());
						startActivity(intent);

						Toast.makeText(getActivity(), list.get(position).getE_id()+"", Toast.LENGTH_SHORT).show();
					}
				});

				recycle.setAdapter(adapter);
			}
			@Override
			public void error(IOException e) {
			}
		});
	}
	@Override
	public void onDestroyView() {
		super.onDestroyView();
	}
	@Override
	public void onDestroy() {
		super.onDestroy();
	}
}