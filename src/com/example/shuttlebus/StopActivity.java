package com.example.shuttlebus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class StopActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.stop_list);
		ListView listView = (ListView) this.findViewById(R.id.stopListView);

		List<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();
		List<String> stops = new ArrayList<String>();
		stops.add("唐家");
		stops.add("tangjia");
		stops.add("您唐");
		stops.add("地点1");
		stops.add("地点3");

		for (int i = 0; i < 5; i++) {
			HashMap<String, Object> item = new HashMap<String, Object>();
			item.put("id", i);
			item.put("name", stops.get(i));
			data.add(item);
		}
		// 创建SimpleAdapter适配器将数据绑定到item显示控件上
		SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.stop_item, new String[] { "name", "icon" }, new int[] { R.id.name,
				R.id.arrowIcon });
		// 实现列表的显示
		listView.setAdapter(adapter);
		// 条目点击事件
		listView.setOnItemClickListener(new ItemClickListener());

		Bundle bundle = this.getIntent().getExtras();
		String name = bundle.getString("name");
		TextView textView = (TextView) this.findViewById(R.id.routName);
		textView.setText(name);

		RadioGroup radioGroup = (RadioGroup) this.findViewById(R.id.timeType);
//		RadioButton radioButton = (RadioButton) this.findViewById(radioGroup.getCheckedRadioButtonId());

		// System.out.println(radioButton.getText());

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

		}
	}

}
