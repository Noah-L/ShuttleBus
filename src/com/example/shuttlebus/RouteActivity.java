package com.example.shuttlebus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.oocl.shuttlebus.mockdata.MockData;
import com.oocl.shuttlebus.model.Route;

public class RouteActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.route_list);
		List<HashMap<String, Object>> routeData = initRouteData();
		initEvent(routeData);
	}

	private List<HashMap<String, Object>> initRouteData() {
		List<Route> routes = MockData.mockRoute();
		List<HashMap<String, Object>> datas = new ArrayList<HashMap<String, Object>>();
		for (Route route : routes) {
			HashMap<String, Object> item = new HashMap<String, Object>();
			item.put("routeId", route.getId());
			item.put("routeName", "No" + route.getName());
			item.put("arrowIcon", R.drawable.arrow_icon);
			datas.add(item);
		}
		return datas;
	}

	private void initEvent(List<HashMap<String, Object>> routData) {
		ListView listView = (ListView) this.findViewById(R.id.routeListView);
		SimpleAdapter adapter = new SimpleAdapter(this, routData, R.layout.route_item, new String[] { "routeName", "arrowIcon" },
				new int[] { R.id.name, R.id.arrowIcon });
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new ItemClickListener());
	}

	private final class ItemClickListener implements OnItemClickListener {

		@SuppressWarnings("unchecked")
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			ListView listView = (ListView) parent;
			HashMap<String, Object> data = (HashMap<String, Object>) listView.getItemAtPosition(position);
			forwardActivity(data);
		}

		private void forwardActivity(HashMap<String, Object> data) {
			Intent intent = new Intent(RouteActivity.this, StopActivity.class);
			Bundle bundle = new Bundle();
			bundle.putString("routeId", data.get("routeId").toString());
			bundle.putString("routeName", data.get("routeName").toString());
			intent.putExtras(bundle);
			startActivity(intent);
		}

	}
}