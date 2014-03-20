package com.bignerdranch.android.criminalintent;

import java.util.ArrayList;
import java.util.UUID;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

public class PagerActivity extends FragmentActivity {
	
	private ViewPager        mViewPager;
	private ArrayList<Data>  mData;
	
	@Override 
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		// This will set the layout programatically, you can do it
		// using XML too
		mViewPager = new ViewPager(this);
		mViewPager.setId(R.id.viewPager);
		setContentView(mViewPager);
		
		// Get data from a lab here
		mData = getDataArray();
		
		FragmentManager fm = getSupportFragmentManager();
		mViewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
			@Override
			public int getCount() {
				return mData.size();
			}
			
			@Override
			public Fragment getItem(int pos) {
				Crime crime = mData.get(pos);
				// The instance is created using a factory method.
				return CrimeFragment.newInstance(crime.getId());
			}
		});
		
		mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			public void onPageScrollStateChanged(int state) {}
			
			public void onPageScrolled(int pos, float posOffset, int posOffsetPixels) {	}
			
			public void onPageSelected(int pos) {
				Crime crime = mData.get(pos);
				if (crime.getTitle() != null) {
					setTitle(crime.getTitle());
				}
			}
		});
		
		UUID crimeId = (UUID) getIntent()
				.getSerializableExtra(CrimeFragment.EXTRA_CRIME_ID);
		for (int i = 0; i < mData.size(); i++) {
			if (mData.get(i).getId().equals(crimeId)) {
				mViewPager.setCurrentItem(i);
				break;
			}
		}
		
	}
	
	

}
