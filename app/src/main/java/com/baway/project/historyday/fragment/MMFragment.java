package com.baway.project.historyday.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.baway.library.okhttp.HttpCallBack;
import com.baway.library.okhttp.NetHttpUtils;
import com.baway.project.historyday.R;
import com.baway.project.historyday.bean.MMbean;
import com.baway.project.historyday.fragment.adapter.MMAdapter;
import com.baway.project.historyday.utils.UIUtils;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.melnykov.fab.FloatingActionButton;

import java.io.IOException;
import java.util.List;

/**
 * 
 * @author 张瑞凯
 * @description 今日
 */
public class MMFragment extends Fragment {
	private XRecyclerView xrecycler;
	private List<MMbean.ResultsBean> list;
	private int page=1;;
	private Button bt_top;
	private GridLayoutManager manager;
	private View view;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		init();
		initdata();
		initListener();
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.frag_mm, null);
		return view;
	}
	public void init(){
		xrecycler = (XRecyclerView) view.findViewById(R.id.xrecycler);
		manager = new GridLayoutManager(getActivity(), 2);
		xrecycler.setLayoutManager(manager);
		bt_top = (Button) view.findViewById(R.id.bt_top);
		xrecycler.setLoadingListener(new XRecyclerView.LoadingListener() {
			@Override
			public void onRefresh() {
				page+=1;
				initdata();
				xrecycler.refreshComplete();
			}
			@Override
			public void onLoadMore() {
				page++;
				initdata();
				xrecycler.loadMoreComplete();

			}
		});
	}
	private void initListener() {
		bt_top.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
			xrecycler.scrollToPosition(0);
			}
		});
	}
	private void initdata(){
		String url="http://gank.io/api/data/福利/11/"+page;
		NetHttpUtils.getInstance().get(getActivity(), url, null, new HttpCallBack<MMbean>() {
			@Override
			public void success(MMbean o) {
			 list = o.results;
				xrecycler.setAdapter(new MMAdapter(getActivity(),list));
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
