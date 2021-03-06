package com.example.shuttlebus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.oocl.shuttlebus.consts.Constant;
import com.oocl.shuttlebus.mockdata.MockData;
import com.oocl.shuttlebus.model.BusStop;
import com.oocl.shuttlebus.model.Route;

public class RouteActivity extends Activity {

	private String routeType;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.route_list);
		Bundle bundle = this.getIntent().getExtras();
		initView(bundle);
		List<HashMap<String, Object>> routeData = initRouteData();
		initListViewEvent(routeData);
		initButtonEvent();
	}

	private void initView(Bundle bundle) {
		TextView textView = (TextView) this.findViewById(R.id.routeType);
		routeType = bundle.get("routeType").toString();
		textView.setText(routeType + Constant.SUFFIX_ROUTE);
	}

	private List<HashMap<String, Object>> initRouteData() {
		List<Route> routes = MockData.mockRoute();
		List<HashMap<String, Object>> datas = new ArrayList<HashMap<String, Object>>();
		for (Route route : routes) {
			// TODO hard code
			if ("上班".equals(routeType)) {
				if ("off".equals(route.getType())) {
					continue;
				}
			} else {
				if ("on".equals(route.getType())) {
					continue;
				}
			}
			// TODO hard code
			HashMap<String, Object> item = new HashMap<String, Object>();
			item.put("route1Icon", R.drawable.route1_icon);
			item.put("routeName", Constant.PREFIX_ROUTE + route.getName() + Constant.BLANK_STRING + getBusStopDescription(route));
			item.put("route", route);
			item.put("arrowIcon", R.drawable.arrow_icon);
			datas.add(item);
		}
		return datas;
	}

	private String getBusStopDescription(Route route) {
		List<BusStop> busStops = route.getStop();
		if (busStops != null && busStops.size() > 1) {
			return Constant.BRACKETS_LEFT + busStops.get(0).getName() + Constant.TO + busStops.get(busStops.size() - 1).getName()
					+ Constant.BRACKETS_RIGHT;
		}
		return Constant.EMPTY_STRING;
	}

	private void initListViewEvent(List<HashMap<String, Object>> routData) {
		ListView listView = (ListView) this.findViewById(R.id.routeListView);
		SimpleAdapter adapter = new SimpleAdapter(this, routData, R.layout.route_item, new String[] { "route1Icon", "routeName",
				"arrowIcon" }, new int[] { R.drawable.route1_icon, R.id.name, R.id.arrowIcon });
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new ItemClickListener());
	}

	private void initButtonEvent() {
		Button returnButton = (Button) findViewById(R.id.returnButton);
		returnButton.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				Intent intent = new Intent(RouteActivity.this, IndexActivity.class);
				startActivity(intent);
			}
		});
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
			bundle.putSerializable("route", (Route) data.get("route"));
			bundle.putString("routeType", routeType);
			intent.putExtras(bundle);
			startActivity(intent);
		}

	}
}