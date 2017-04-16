package com.baway.project.historyday.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.baway.project.historyday.R;
import com.baway.project.historyday.activity.Detail;
import com.baway.project.historyday.dbutils.DBBean;
import com.baway.project.historyday.dbutils.Dao;

import java.util.List;

public class FavoritiesFragment extends Fragment {

	Dao dao;
	private LinearLayout lin_collect;
	private RelativeLayout rel_no_collect;
	private ListView lv_collect;
	private View view;
	private List<DBBean> list;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		init();


	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.frag_myfavorities, null);

		return view;
	}
	private void init() {


		dao = new Dao(getActivity());

		list = dao.findAll();
		lin_collect = (LinearLayout) view.findViewById(R.id.lin_collect);
		rel_no_collect = (RelativeLayout) view.findViewById(R.id.rel_no_collect);
		lv_collect = (ListView) view.findViewById(R.id.lv_collect);
		if (list.size()!=0) {
			lin_collect.setVisibility(View.VISIBLE);
			rel_no_collect.setVisibility(View.GONE);
			lv_collect.setAdapter(new CollectAdapter(list, getActivity()));
		}

		lv_collect.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
				Intent intent=new Intent(getActivity(), Detail.class);

				intent.putExtra("qid",list.get(i).getE_id());
				startActivity(intent);

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
