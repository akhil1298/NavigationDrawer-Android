package com.akhilbatlawala.navigationdrawer;

import com.example.navigationdrawer.R;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

@SuppressLint("NewApi")
public class FragmentThree extends Fragment {

	
	TextView tvItemName;
	
	public FragmentThree() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_layout_three, container,
				false);

		tvItemName = (TextView) view.findViewById(R.id.frag3_text);

		tvItemName.setText("Fragement 3");

		return view;
	}

}
