package com.example.t_a_fragmenttabhost;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class Fragment1 extends Fragment {
	private View layoutView;
	private FragmentManager fm;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		fm = getChildFragmentManager();
		TestFragmentTabHost.fragmentStack.add(new ActiivtyStack(fm));
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		layoutView = inflater.inflate(R.layout.fragment1, null);
		layoutView.findViewById(R.id.btn).setOnClickListener(
				new OnClickListener() {
					@Override
					public void onClick(View v) {
						FragmentTransaction ft = fm.beginTransaction();
						TestFragmentTabHost.fragmentStack.get(0).pushActivity(
								new A());
						ft.add(R.id.realtabcontent,
								TestFragmentTabHost.fragmentStack.get(0)
										.currentActivity());
						ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
						ft.addToBackStack(null);
						ft.commit();
					}
				});
		return layoutView;
	}

}
