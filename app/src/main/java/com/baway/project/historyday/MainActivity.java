package com.baway.project.historyday;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.baway.project.historyday.fragment.LeftFragment;
import com.baway.project.historyday.fragment.TodayFragment;
import com.jaeger.library.StatusBarUtil;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

/**
 * @date 2017/03/15
 * @author 张瑞凯
 * @description 主界面
 */
public class MainActivity extends SlidingFragmentActivity implements
		OnClickListener {
	private ImageView topButton;
	private Fragment mContent;
	private TextView topTextView;
	private int mColor= Color.RED;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE); // 无标题
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		StatusBarUtil.setColor(MainActivity.this, mColor);
		if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT) {
			getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

		}
		initSlidingMenu(savedInstanceState);

		topButton = (ImageView) findViewById(R.id.topButton);
		topButton.setOnClickListener(this);
		topTextView = (TextView) findViewById(R.id.topTv);


		Intent intent = getIntent();

		int id = intent.getIntExtra("id",0);
		int index = intent.getIntExtra("index",1);
		if(id==1){
			TodayFragment f1=new TodayFragment();
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.content_frame, f1).commit();
			topTextView.setText("历史上的今天");
		}

		if(index==5){
//			TodayFragment f1=new TodayFragment();
//			FragmentManager manager = getSupportFragmentManager();
//			FragmentTransaction transaction = manager.beginTransaction();
//			transaction.show(f1).commit();
			TodayFragment f1=new TodayFragment();
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.content_frame, f1).commit();
			topTextView.setText("历史上的今天");
		}

	}

	/**
	 * 初始化侧边栏
	 */
	private void initSlidingMenu(Bundle savedInstanceState) {
		// 如果保存的状态不为空则得到之前保存的Fragment，否则实例化MyFragment
		if (savedInstanceState != null) {
			mContent = getSupportFragmentManager().getFragment(
					savedInstanceState, "mContent");
		}
		if (mContent == null) {
			mContent = new TodayFragment();
		}
		// 设置左侧滑动菜单
		setBehindContentView(R.layout.menu_frame_left);
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.menu_frame, new LeftFragment()).commit();
		// 实例化滑动菜单对象
		SlidingMenu sm = getSlidingMenu();
		// 设置可以左右滑动的菜单
		sm.setMode(SlidingMenu.LEFT);
		// 设置滑动阴影的宽度
		sm.setShadowWidthRes(R.dimen.shadow_width);

		// 设置滑动菜单阴影的图像资源
		sm.setShadowDrawable(null);

		// 设置滑动菜单视图的宽度
		sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);

		// 设置渐入渐出效果的值
		sm.setFadeDegree(0.35f);

		// 设置触摸屏幕的模式,这里设置为全屏
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);

		// 设置下方视图的在滚动时的缩放比例
		sm.setBehindScrollScale(0.0f);

	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
//		getSupportFragmentManager().putFragment(outState, "mContent", mContent);
	}
	/**
	 * 切换Fragment
	 *
	 * @param fragment
	 */
	public void switchConent(Fragment fragment, String title) {
		mContent = fragment;
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.content_frame, fragment).commit();
		getSlidingMenu().showContent();
		topTextView.setText(title);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.topButton:
			toggle();
			break;
		default:
			break;
		}
	}

}
