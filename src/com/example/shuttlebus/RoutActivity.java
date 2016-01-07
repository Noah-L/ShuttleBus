package com.example.shuttlebus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class RoutActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rout_list);
		ListView listView = (ListView) this.findViewById(R.id.routListView);

		List<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < 5; i++) {
			HashMap<String, Object> item = new HashMap<String, Object>();
			item.put("id", i);
			item.put("name", "路线" + (i + 1));
			item.put("arrowIcon", R.drawable.arrow_icon);
			data.add(item);
		}
		// 创建SimpleAdapter适配器将数据绑定到item显示控件上
		SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.rout_item, new String[] { "name", "arrowIcon" }, new int[] {
				R.id.name, R.id.arrowIcon });
		// 实现列表的显示
		listView.setAdapter(adapter);
		// 条目点击事件
		listView.setOnItemClickListener(new ItemClickListener());
	}

	// 获取点击事件
	private final class ItemClickListener implements OnItemClickListener {

		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			ListView listView = (ListView) parent;
			HashMap<String, Object> data = (HashMap<String, Object>) listView.getItemAtPosition(position);
			String personid = data.get("id").toString();
			//Toast.makeText(getApplicationContext(), personid, 1).show();
			// TODO
			String routName = data.get("name").toString();

			Intent intent = new Intent(RoutActivity.this, StopActivity.class);
			Bundle bundle = new Bundle();
			bundle.putString("name", routName);
			intent.putExtras(bundle);
			startActivity(intent);
		}
	}
}