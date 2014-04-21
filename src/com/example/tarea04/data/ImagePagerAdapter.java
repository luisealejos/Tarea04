package com.example.tarea04.data;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.tarea04.R;
import com.example.tarea04.fragments.ImageFragment;

public class ImagePagerAdapter extends FragmentPagerAdapter {

	private int[] arrayMall = new int[] {
			R.drawable.mall01,
			R.drawable.mall02,
			R.drawable.mall03,
			R.drawable.mall04,
			R.drawable.mall05
		};
		
		public ImagePagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			Fragment fragment = new ImageFragment();
			Bundle args = new Bundle();
			args.putInt(ImageFragment.RESOURCE, arrayMall[position]);
			fragment.setArguments(args);
			return fragment;
		}

		@Override
		public int getCount() {
			return arrayMall.length;
		}

}
