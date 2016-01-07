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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.oocl.shuttlebus.common.SharePreferenceHelper;
import com.oocl.shuttlebus.consts.Constant;
import com.oocl.shuttlebus.model.BusStop;
import com.oocl.shuttlebus.model.Route;
import com.oocl.shuttlebus.model.Ticket;
import com.oocl.shuttlebus.model.User;

public class StopActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.stop_list);
		Bundle bundle = this.getIntent().getExtras();
		Route route = (Route) bundle.get("route");
		initView(route);
		List<HashMap<String, Object>> stopData = initStopData(route);
		initEvent(stopData);
	}

	private void initView(Route route) {
		TextView textView = (TextView) this.findViewById(R.id.routName);
		textView.setText(Constant.PREFIX_ROUTE + route.getName());
	}

	public void confirmTicket(View view) {

		String timeType = getTimeType();

		List<Ticket> tickets = new ArrayList<Ticket>();
		Ticket ticket = new Ticket();
		User user = SharePreferenceHelper.getUser(this.getApplicationContext());
		// TODO
		ticket.setId(1L);
		ticket.setDate("2016-01-08");
		ticket.setBusStop(null);
		ticket.setRoute(null);
		// TODO
		ticket.setType(timeType);
		ticket.setUser(user);
		tickets.add(ticket);
		SharePreferenceHelper.saveTickets(this.getApplicationContext(), tickets);
	}

	// TODO method name refactoring
	private String getTimeType() {
		RadioGroup radioGroup = (RadioGroup) this.findViewById(R.id.timeType);
		RadioButton radioButton = (RadioButton) this.findViewById(radioGroup.getCheckedRadioButtonId());
		return radioButton.getText() == null ? Constant.EMPTY_STRING : radioButton.getText().toString();
	}

	private void initEvent(List<HashMap<String, Object>> stopData) {
		ListView listView = (ListView) this.findViewById(R.id.stopListView);
		SimpleAdapter adapter = new SimpleAdapter(this, stopData, R.layout.stop_item, new String[] { "stopName" }, new int[] { R.id.name });
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new ItemClickListener());

	}

	private List<HashMap<String, Object>> initStopData(Route route) {
		List<BusStop> busStops = route.getStop();
		List<HashMap<String, Object>> datas = new ArrayList<HashMap<String, Object>>();
		if (busStops != null && busStops.size() > 0) {
			for (BusStop busStop : busStops) {
				HashMap<String, Object> item = new HashMap<String, Object>();
				item.put("stopId", busStop.getId());
				item.put("stopName", busStop.getName());
				datas.add(item);
			}
		}
		return datas;
	}

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
