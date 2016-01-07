package com.example.shuttlebus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.oocl.shuttlebus.mockdata.MockData;
import com.oocl.shuttlebus.model.BusStop;
import com.oocl.shuttlebus.model.Route;

public class StopActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.stop_list);
		Bundle bundle = this.getIntent().getExtras();
		initView(bundle);
		List<HashMap<String, Object>> stopData = initStopData(bundle);
		initEvent(stopData);
	}

	private void initView(Bundle bundle) {
		TextView textView = (TextView) this.findViewById(R.id.routName);
		textView.setText(bundle.getString("routeName"));
	}

	private void initEvent(List<HashMap<String, Object>> stopData) {
		ListView listView = (ListView) this.findViewById(R.id.stopListView);
		SimpleAdapter adapter = new SimpleAdapter(this, stopData, R.layout.stop_item, new String[] { "stopName" }, new int[] { R.id.name });
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new ItemClickListener());

		RadioGroup radioGroup = (RadioGroup) this.findViewById(R.id.timeType);
		// RadioButton radioButton = (RadioButton)
		// this.findViewById(radioGroup.getCheckedRadioButtonId());

		// System.out.println(radioButton.getText());

	}

	private List<HashMap<String, Object>> initStopData(Bundle bundle) {
		String routeId = bundle.getString("routeId");
		List<HashMap<String, Object>> datas = new ArrayList<HashMap<String, Object>>();
		List<Route> routes = MockData.mockRoute();
		// TODO not 1
		Route route = routes.get(1);
		if (route != null && route.getStop() != null && route.getStop().size() > 0) {
			for (BusStop busStop : route.getStop()) {
				HashMap<String, Object> item = new HashMap<String, Object>();
				// item.put("stopId", busStop.getId());// TODO 缺少id
				item.put("stopName", busStop.getName());
				datas.add(item);
			}
		}
		return datas;
	}

	// 获取点击事件
	private final class ItemClickListener implements OnItemClickListener {

		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			ListView listView = (ListView) parent;
			HashMap<String, Object> data = (HashMap<String, Object>) listView.getItemAtPosition(position);
			String personid = data.get("id").toString();
			// Toast.makeText(getApplicationContext(), personid, 1).show();
			// TODO
			String routName = data.get("name").toString();

		}
	}

}
