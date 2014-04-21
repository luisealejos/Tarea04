package com.example.tarea04.fragments;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.tarea04.R;
import com.example.tarea04.activities.CameraActivity;
import com.example.tarea04.fragments.PhotoDialogFragment.NoticeDialogListener;

public class ComunityFragment extends Fragment implements OnClickListener, OnItemClickListener, NoticeDialogListener {
	
	ImageView imageview1;
	Button ButtonCamera;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {	
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_comunity, null);
		imageview1 = (ImageView)view.findViewById(R.id.imageViewComunity);
		Resources res = getResources();
		Drawable drawable = res.getDrawable(R.drawable.artemis);
		imageview1.setImageDrawable(drawable);
		
		ButtonCamera = (Button)view.findViewById(R.id.ButtonCamera);
		ButtonCamera.setOnClickListener(this);
		
		return view;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v.getId() == ButtonCamera.getId()) {
			new PhotoDialogFragment().show(getFragmentManager(), "");
		}
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onDialogPositiveClick() {
		Intent intent = new Intent(getActivity().getApplicationContext(), CameraActivity.class);
		startActivity(intent);
	}

	@Override
	public void onDialogNegativeClick() {
		Toast.makeText(getActivity().getApplicationContext(), "Hizo click en no :(", Toast.LENGTH_SHORT).show();	
	}
	
}
