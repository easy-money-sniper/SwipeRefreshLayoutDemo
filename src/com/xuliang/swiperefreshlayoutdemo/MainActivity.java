package com.xuliang.swiperefreshlayoutdemo;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity implements OnRefreshListener {

	private SwipeRefreshLayout mSwipeLayout;
	private ListView mListView;
	private ArrayList<String> mList;
	private ArrayAdapter<String> mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		init();
	}

	/**
	 * 初始化控件和数据
	 */
	private void init() {
		// TODO Auto-generated method stub
		mListView = (ListView) findViewById(R.id.listview);
		mAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, getListData());
		mListView.setAdapter(mAdapter);

		mSwipeLayout = (SwipeRefreshLayout) findViewById(R.id.swiper_layout);
		mSwipeLayout.setOnRefreshListener(this);
		mSwipeLayout.setColorSchemeResources(android.R.color.holo_purple,
				android.R.color.holo_orange_light,
				android.R.color.holo_green_light, android.R.color.holo_blue_light);
	}

	/**
	 * 得到mList数据
	 * 
	 * @return
	 */
	private ArrayList<String> getListData() {
		// TODO Auto-generated method stub
		mList = new ArrayList<String>();
		mList.add("Hello !");
		mList.add("This is easy-money-sniper .");
		mList.add("This is a SwipeRefreshLayoutDemo .");
		mList.add("You can pull it down to refresh !");
		// mList.add("Easy to use !");
		return mList;
	}

	@Override
	public void onRefresh() {
		// TODO Auto-generated method stub
		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				mList.addAll(0, mList);
				mAdapter.notifyDataSetChanged();
				mSwipeLayout.setRefreshing(false);
			}
		}, 3000);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
