package com.example.t_a_fragmenttabhost;

import java.util.ArrayList;

import junit.framework.Assert;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

public class TestFragmentTabHost extends FragmentActivity {
	private FragmentTabHost mTabHost;
	private String[] TabTag = { "tab1", "tab2", "tab3", "tab4", "tab5" };
	private String[] IndicatorTxt = { "首页", "新闻", "评论", "推荐", "更多" };
	private Class[] cls = { Fragment1.class, Fragment2.class, Fragment3.class,
			Fragment4.class, Fragment5.class };
	public static ArrayList<ActiivtyStack> fragmentStack;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_linear);

		Assert.assertEquals(TabTag.length, IndicatorTxt.length);

		mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
		mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

		fragmentStack = new ArrayList<ActiivtyStack>();
		for (int i = 0; i < IndicatorTxt.length; i++) {
			View indicator = getIndicatorView(i);
			mTabHost.addTab(
					mTabHost.newTabSpec(TabTag[i]).setIndicator(indicator),
					cls[i], null);
		}
	}

	private View getIndicatorView(int i) {
		View v = getLayoutInflater().inflate(R.layout.tab_indicator_1, null);
		TextView tv = (TextView) v.findViewById(R.id.textView1);
		tv.setText(this.IndicatorTxt[i]);
		return v;
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
			switch (mTabHost.getCurrentTab()) {
			case 0:
				if (fragmentStack.get(0).getFragmentSize() > 0) {
					fragmentStack.get(0).popActivity(
							fragmentStack.get(0).currentActivity());
					return false;
				}
				break;
			case 1:

				break;
			case 2:

				break;
			case 3:

				break;
			case 4:

				break;
			default:
				break;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
}
