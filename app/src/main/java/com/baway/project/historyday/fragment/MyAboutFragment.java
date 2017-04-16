package com.baway.project.historyday.fragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baway.project.historyday.R;
/**
 * 
 * @author 张瑞凯
 * @description 今日
 */
public class MyAboutFragment extends Fragment {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.frag_about, null);
		return view;
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
