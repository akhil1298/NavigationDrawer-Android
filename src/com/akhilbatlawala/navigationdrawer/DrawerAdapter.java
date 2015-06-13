package com.akhilbatlawala.navigationdrawer;

import java.util.List;

import android.content.Context;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class DrawerAdapter extends BaseAdapter{

	Context cn;
	List<DrawerItem> dataList;
	int Layout = 0;
	
	public DrawerAdapter(Context cn, List<DrawerItem> dataList) {
		super();
		this.cn = cn;
		this.dataList = dataList;
	}
	
	public DrawerAdapter(Context cn, List<DrawerItem> dataList, int layout) {
		super();
		this.cn = cn;
		this.dataList = dataList;
		Layout = layout;
	}

	@Override
	public int getCount() {
		return dataList.size();
	}

	@Override
	public Object getItem(int position) {
		
		return dataList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		DrawerItem item = (DrawerItem) this.getItem(position);
		ViewHolder holder;
		
		if(convertView == null)
		{
			holder = new ViewHolder();
			if(Layout == 0)
				convertView = LayoutInflater.from(cn).inflate(com.example.navigationdrawer.R.layout.custom_drawer_item, parent,false);
			else
				convertView = LayoutInflater.from(cn).inflate(Layout, parent,false);
			
			holder.img = (ImageView)convertView.findViewById(com.example.navigationdrawer.R.id.itemicon);
			holder.txt = (TextView)convertView.findViewById(com.example.navigationdrawer.R.id.itemName);
			convertView.setTag(holder);
		}else
			holder = (ViewHolder) convertView.getTag();
		
		try{
			holder.img.setImageResource(item.getImgId());
			holder.txt.setText(item.getName());
			
		}catch(Exception e){
			Log.d("Error in adapter", e.getMessage());
		}
		
		return convertView;
	}
	
	public class ViewHolder{
		ImageView img;
		TextView txt;
	}

}
