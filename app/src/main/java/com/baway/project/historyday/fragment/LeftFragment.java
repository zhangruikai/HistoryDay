package com.baway.project.historyday.fragment;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.baway.project.historyday.MainActivity;
import com.baway.project.historyday.R;
import com.jaeger.library.StatusBarUtil;

/**
 * @date 2017/03/17
 * @author 张瑞凯
 * @description 侧边栏菜单
 */
public class LeftFragment extends Fragment implements OnClickListener{
	private View todayView;
	private View tvMMDD;
	private View tvMyAbout;
	private View tvSc;
	private int mColor= Color.RED;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.layout_menu, null);

		StatusBarUtil.setColor(getActivity(), mColor);
		if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT) {
			getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
		}



		findViews(view);

		return view;
	}


	public void findViews(View view) {

		tvSc = view.findViewById(R.id.tvSc);
		tvMyAbout = view.findViewById(R.id.tvMyAbout);
		tvMMDD = view.findViewById(R.id.tvMMDD);
		todayView = view.findViewById(R.id.tvToday);


		tvSc.setOnClickListener(this);
		tvMyAbout.setOnClickListener(this);
		tvMMDD.setOnClickListener(this);
		todayView.setOnClickListener(this);



	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	@Override
	public void onClick(View v) {
		Fragment newContent = null;
		String title = null;
		switch (v.getId()) {
		case R.id.tvToday: //今日
			newContent = new TodayFragment();
			title = getString(R.string.today);
			break;
		case R.id.tvMMDD://妹纸

			newContent = new MMFragment();
			title = getString(R.string.tvMMDD);
			break;
		case R.id.tvSc: //收藏

			newContent = new FavoritiesFragment();
			title = getString(R.string.myFavorities);
			break;
		case R.id.tvMyAbout: // 关于

			newContent = new MyAboutFragment();
			title = getString(R.string.settings);
			break;
		default:
			break;
		}
		if (newContent != null) {
			switchFragment(newContent, title);
		}
	}

	/**
	 * 切换fragment
	 * @param fragment
	 */
	private void switchFragment(Fragment fragment, String title) {
		if (getActivity() == null) {
			return;
		}
		if (getActivity() instanceof MainActivity) {
			MainActivity fca = (MainActivity) getActivity();
			fca.switchConent(fragment, title);
		}
	}

}
